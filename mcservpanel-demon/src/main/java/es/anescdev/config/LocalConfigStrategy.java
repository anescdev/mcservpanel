package es.anescdev.config;

import jakarta.annotation.Nonnull;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LocalConfigStrategy implements ConfigStrategy{
    private Properties config;
    protected LocalConfigStrategy(){
        final Path BASE_DIR = Paths.get(System.getProperty("user.home"), ".mcservdemon");
        final File configFile = new File(BASE_DIR.toFile(),"config.properties");
        Properties tempProperties = new Properties();
        if(configFile.exists()){
            try(FileInputStream fis = new FileInputStream(configFile)){
                tempProperties.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try(FileOutputStream fos = new FileOutputStream(configFile)){
                tempProperties.setProperty(ConfigParam.SERVER_JAR_FOLDER.getPropertyName(), Path.of(BASE_DIR.toString(),"jar_files").toString());
                tempProperties.setProperty(ConfigParam.SERVER_DATA_FOLDER.getPropertyName(), Path.of(BASE_DIR.toString(),"server_data").toString());
                tempProperties.setProperty(ConfigParam.ALLOW_REMOTE_MODULE_INSTALL.getPropertyName(), String.valueOf(false));
                tempProperties.store(fos, "");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = tempProperties;
    }

    @Override
    public String getConfigValue(@Nonnull ConfigParam configParam) {
        return this.config.getProperty(configParam.getPropertyName());
    }
}
