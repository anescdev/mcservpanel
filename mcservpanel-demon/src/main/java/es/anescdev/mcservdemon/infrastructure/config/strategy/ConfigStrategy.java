package es.anescdev.mcservdemon.infrastructure.config.strategy;

public interface ConfigStrategy {
    String serverJarfolder();
    String serverDataFolder();
    String instanceName();
}
