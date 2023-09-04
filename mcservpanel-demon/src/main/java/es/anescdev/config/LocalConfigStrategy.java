package es.anescdev.config;

import es.anescdev.McServDemon;
import jakarta.annotation.Nonnull;

import java.io.*;
import java.util.Properties;

public class LocalConfigStrategy implements ConfigStrategy{
    private final Properties config;
    protected LocalConfigStrategy() throws IOException {
        this.config = new Properties();
        FileInputStream fis = new FileInputStream(McServDemon.CONFIG_FILE);
        this.config.load(fis);
    }

    @Override
    public String getConfigValue(@Nonnull ConfigParam configParam) {
        return this.config.getProperty(configParam.getPropertyName());
    }
}
