package es.anescdev.mcservdemon.jarmanager;

import es.anescdev.mcservdemon.jarmanager.model.JarManagerRepository;
import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class ServerJarJarManager implements JarManagerRepository {
    private HashMap<ServerType, File> jarsDownloaded;

    protected ServerJarJarManager(){

    }
    @Override
    public HashSet<ServerType> checkJarUpgrade() {
        return null;
    }

    @Override
    public boolean checkJarUpgrade(ServerType serverType) {
        return false;
    }

    @Override
    public void downloadJar(ServerType serverType) {}

    @Override
    public File getJar(ServerType serverType) {
        return null;
    }
}
