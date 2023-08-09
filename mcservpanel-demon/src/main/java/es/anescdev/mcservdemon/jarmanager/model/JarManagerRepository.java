package es.anescdev.mcservdemon.jarmanager.model;

import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.io.File;
import java.util.HashSet;

public interface JarManagerRepository {
    HashSet<ServerType> checkJarUpgrade();
    boolean checkJarUpgrade(ServerType serverType);
    void downloadJar(ServerType serverType);
    File getJar(ServerType serverType);
}
