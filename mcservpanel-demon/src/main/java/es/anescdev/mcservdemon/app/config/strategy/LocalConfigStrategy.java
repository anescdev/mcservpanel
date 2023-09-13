package es.anescdev.mcservdemon.app.config.strategy;

import es.anescdev.mcservdemon.McServDemon;
import es.anescdev.mcservdemon.app.config.ConfigParam;
import jakarta.annotation.Nonnull;

import java.io.*;
import java.util.Properties;

public class LocalConfigStrategy implements ConfigStrategy{
    private final Properties config;
    public LocalConfigStrategy() throws IOException {
        this.config = new Properties();
        FileInputStream fis = new FileInputStream(McServDemon.CONFIG_FILE);
        this.config.load(fis);
    }

    private String getConfigValue(@Nonnull ConfigParam configParam) {
        return this.config.getProperty(configParam.getPropertyName());
    }

    @Override
    public String serverJarfolder() {
        return this.getConfigValue(ConfigParam.INSTANCE_JAR_FOLDER);
    }

    @Override
    public String serverDataFolder() {
        return this.getConfigValue(ConfigParam.INSTANCE_DATA_FOLDER);
    }

    @Override
    public String instanceName() {
        return this.getConfigValue(ConfigParam.SERVER_NAME);
    }
}
