package es.anescdev.mcservdemon.context.jarmanager.domain.repository;

import es.anescdev.mcservdemon.context.jarmanager.domain.model.ServerVersion;

import java.io.File;
import java.util.List;

public interface JarManagerRepository {
    //TODO: Pensar que parámetros pasarle a downloadJar
    File downloadJar();
    boolean saveJar(File jarFile);
    boolean removeJar(File jarFile);
    //TODO: Cambiar el tipo que devuelve a uno con más conveniente que de los datos necesarios
    boolean checkJarsUpgrade();
    //TODO: Método para actualizar el jar que se comprobó con checkJarsUpgrade.
}
