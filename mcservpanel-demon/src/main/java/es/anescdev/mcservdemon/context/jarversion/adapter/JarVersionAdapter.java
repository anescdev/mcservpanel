package es.anescdev.mcservdemon.context.jarversion.adapter;

import es.anescdev.mcservdemon.McServDemon;
import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersion;
import es.anescdev.mcservdemon.app.versionspack.parser.IVersionPackParser;
import es.anescdev.mcservdemon.app.versionspack.parser.RVersionPackEntry;
import es.anescdev.mcservdemon.app.versionspack.parser.VersionPackParser;
import es.anescdev.mcservdemon.context.jarversion.domain.port.JarVersionPort;
import io.quarkus.runtime.Application;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JarVersionAdapter implements JarVersionPort {

    private static JarVersionPort instance;
    private final List<JarVersion> versions;
    private JarVersionAdapter(List<JarVersion> versions){
        this.versions = versions;
    }

    public static JarVersionPort getInstance(){
        if(JarVersionAdapter.instance == null){
            IVersionPackParser parser = new VersionPackParser();
            File vpfDir = new File(McServDemon.BASE_DIR.toFile(), "vpf");
            if(!vpfDir.exists() || !vpfDir.isDirectory()){
                if(!vpfDir.mkdir()){
                    System.out.println("Killo que me tienes hecho un lio y no puedo crear la carpeta");
                    Application.currentApplication().close();
                }
            }
            File[] packs = vpfDir.listFiles(File::isDirectory);
            List<JarVersion> tempVersions = new ArrayList<>();
            assert packs != null;
            for(File pack: packs){
                File jarsDir = Path.of(pack.getAbsolutePath(),"jars").toFile();
                File versionFile = Path.of(pack.getAbsolutePath(), "versions.vpf").toFile();
                Optional<List<RVersionPackEntry>> versionPackEntries = parser.parseVersionsPack(versionFile);
                versionPackEntries.ifPresent(
                        rVersionPackEntries ->
                                tempVersions.addAll(rVersionPackEntries.stream().map(
                                        (actEntry) ->
                                                new JarVersion(actEntry.tag(),
                                                        actEntry.version(),
                                                        new File(jarsDir, actEntry.serverJar())))
                                        .toList()));
            }
            JarVersionAdapter.instance = new JarVersionAdapter(tempVersions);
            JarVersionAdapter adapter = (JarVersionAdapter)instance;
            for (JarVersion jarVersion : instance.findAll().list()) {
                if(!adapter.hasVersion(jarVersion))
                    instance.delete(jarVersion);
            }
        }
        return JarVersionAdapter.instance;
    }

    @Override
    public List<JarVersion> getJarVersions() {
        return this.versions.stream().toList();
    }

    @Override
    public List<JarVersion> getJarVersionsByTag(String tag) {
        return this.versions.stream().filter(rJarVersion -> rJarVersion.getTag().contains(tag)).toList();
    }

    @Override
    public List<JarVersion> getJarVersionsByVersion(String version) {
        return this.versions.stream().filter(rJarVersion -> rJarVersion.getVersion().equals(version)).toList();
    }

    @Override
    public List<JarVersion> getJarVersions(String tag, String version) {
        return this.versions.stream().filter(
                rJarVersion ->
                        rJarVersion.getVersion().equals(version) && rJarVersion.getTag().contains(tag))
                .toList();
    }
    
    protected boolean hasVersion(JarVersion version){
        return this.versions.contains(version);
    }
}
