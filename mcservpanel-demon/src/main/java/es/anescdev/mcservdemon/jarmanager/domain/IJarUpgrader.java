package es.anescdev.mcservdemon.jarmanager.domain;

import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.util.HashSet;

/**
 * Interfaz que debe de ser implementada para la creación de la clase encargada
 * de actualizar el .jar
 */
public interface IJarUpgrader{
    HashSet<ServerType> upgradeJar(ServerType serverType);
}