package es.anescdev.mcservdemon.context.jarversion.domain.port;

import es.anescdev.mcservdemon.context.jarversion.domain.model.RJarVersion;

import java.util.List;

public interface JarVersionPort {
    List<RJarVersion> getJarVersions();
    List<RJarVersion> getJarVersionsByTag(String tag);
    List<RJarVersion> getJarVersionsByVersion(String version);
    List<RJarVersion> getJarVersions(String tag, String version);
}
