package es.anescdev.mcservdemon.context.jarmanager.domain.repository;

import es.anescdev.mcservdemon.context.jarmanager.domain.model.ServerVersion;

import java.util.List;

public interface QueryJarRepository {
    List<String> getAvailablePlatforms();
    List<ServerVersion> getVersionPlatform(String platform);
}
