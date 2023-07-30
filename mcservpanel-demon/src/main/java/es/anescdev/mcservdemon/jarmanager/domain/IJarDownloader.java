package es.anescdev.mcservdemon.jarmanager.domain;

import es.anescdev.mcspcommons.models.servertype.ServerType;

public interface IJarDownloader {
    void downloadJar(ServerType serverType);
}
