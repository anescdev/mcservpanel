package es.anescdev.mcservdemon.jarmanager.domain;

import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.io.File;
import java.util.HashSet;
import java.util.List;

public interface JarManagerRepository {
    List<ServerType> checkJarUpgrade();
    boolean checkJarUpgrade(ServerType serverType);
    void downloadJar(ServerType serverType);
    HashSet<ServerType> upgradeJar(ServerType serverType);
    File getJar(ServerType serverType);
}
