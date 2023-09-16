package es.anescdev.mcservdemon.context.jarmanager.adapter;

import es.anescdev.mcservdemon.context.jarmanager.domain.model.ServerVersion;
import es.anescdev.mcservdemon.context.jarmanager.domain.repository.JarManagerRepository;
import es.anescdev.mcservdemon.context.jarmanager.domain.repository.QueryJarRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.File;
import java.util.*;

@ApplicationScoped
public class JarManagerService implements JarManagerRepository, QueryJarRepository {
    private final Map<String, Set<ServerVersion>> serversCatalog;
    public JarManagerService(){
        this.serversCatalog = new HashMap<>();
    }
    @Override
    public File downloadJar() {
        return null;
    }

    @Override
    public boolean saveJar(File jarFile) {
        return false;
    }

    @Override
    public boolean removeJar(File jarFile) {
        return false;
    }

    @Override
    public boolean checkJarsUpgrade() {
        return false;
    }

    // QueryJarRepo
    @Override
    public List<String> getAvailablePlatforms() {
        return this.serversCatalog.keySet().stream().toList();
    }

    @Override
    public List<ServerVersion> getVersionPlatform(String platform) {
        Set<ServerVersion> foundedPlatform = this.serversCatalog.get(platform);
        if(foundedPlatform==null)
            return Collections.unmodifiableList(new LinkedList<>());
        return foundedPlatform.stream().toList();
    }
}
