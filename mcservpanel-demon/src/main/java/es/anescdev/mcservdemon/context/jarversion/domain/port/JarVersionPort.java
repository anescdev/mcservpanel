package es.anescdev.mcservdemon.context.jarversion.domain.port;

import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersion;
import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersionPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.List;

public interface JarVersionPort extends PanacheRepositoryBase<JarVersion, JarVersionPK>{
    List<JarVersion> getJarVersions();
    List<JarVersion> getJarVersionsByTag(String tag);
    List<JarVersion> getJarVersionsByVersion(String version);
    List<JarVersion> getJarVersions(String tag, String version);
}
