package es.anescdev.mcservdemon.jarmanager.domain;
import java.util.List;

import es.anescdev.mcspcommons.models.servertype.ServerType;

public interface IJarChecker{
    List<ServerType> checkJarUpgrade();
    boolean checkJarUpgrade(ServerType serverType);
}