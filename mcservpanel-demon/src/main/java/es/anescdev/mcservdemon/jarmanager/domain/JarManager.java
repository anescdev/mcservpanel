package es.anescdev.mcservdemon.jarmanager.domain;

import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.io.File;
import java.util.HashSet;
import java.util.List;

public class JarManager implements JarManagerRepository {


    @Override
    public List<ServerType> checkJarUpgrade() {
        return null;
    }

    @Override
    public boolean checkJarUpgrade(ServerType serverType) {
        return false;
    }

    @Override
    public void downloadJar(ServerType serverType) {

    }

    @Override
    public HashSet<ServerType> upgradeJar(ServerType serverType) {
        return null;
    }

    @Override
    public File getJar(ServerType serverType) {
        return null;
    }
}
