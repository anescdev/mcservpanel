package es.anescdev.mcservdemon.infrastructure.config;

public enum ConfigParam {
    SERVER_JAR_FOLDER,
    SERVER_DATA_FOLDER,
    ALLOW_REMOTE_MODULE_INSTALL;
    public String getPropertyName(){
        return this.name().toLowerCase();
    }
}
