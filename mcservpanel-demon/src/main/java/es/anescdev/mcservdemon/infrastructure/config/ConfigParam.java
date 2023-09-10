package es.anescdev.mcservdemon.infrastructure.config;

public enum ConfigParam {
    INSTANCE_JAR_FOLDER,
    INSTANCE_DATA_FOLDER,
    SERVER_NAME;
    public String getPropertyName(){
        return this.name().toLowerCase();
    }
}

