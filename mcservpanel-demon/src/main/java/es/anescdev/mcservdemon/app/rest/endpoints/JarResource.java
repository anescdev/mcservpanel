package es.anescdev.mcservdemon.app.rest.endpoints;

import es.anescdev.mcservdemon.context.jarmanager.domain.repository.QueryJarRepository;
import jakarta.inject.Inject;

public class JarResource {
    @Inject
    QueryJarRepository repo;
}
