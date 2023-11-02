package es.anescdev.mcservdemon.app;

import es.anescdev.mcservdemon.context.jarversion.adapter.JarVersionAdapter;
import es.anescdev.mcservdemon.context.jarversion.domain.port.JarVersionPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

public class Initializer {
    @Produces
    @ApplicationScoped
    JarVersionPort versionAdapter(){
        return JarVersionAdapter.getInstance();
    }
}
