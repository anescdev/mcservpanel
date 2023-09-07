package es.anescdev.mcservdemon.infrastructure.config.generator;

import es.anescdev.mcservdemon.McServDemon;
import es.anescdev.mcservdemon.infrastructure.config.ConfigParam;
import jakarta.annotation.Nonnull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class LocalConfigGenerator implements ConfigGenerator{
    @Override
    public boolean generateConfig() {
        Properties tempConfig = new Properties();
        this.setDefaultConfig(tempConfig);
        File dir = McServDemon.BASE_DIR.toFile();
        if(!dir.exists()){
            dir.mkdir();
        }
        try(FileOutputStream fos = new FileOutputStream(McServDemon.CONFIG_FILE)){
            tempConfig.store(fos,"");
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private void setDefaultConfig(@Nonnull Properties configObject) {
        configObject.setProperty(ConfigParam.SERVER_JAR_FOLDER.getPropertyName(), Path.of(McServDemon.BASE_DIR.toString(),"jar_files").toString());
        configObject.setProperty(ConfigParam.SERVER_DATA_FOLDER.getPropertyName(), Path.of(McServDemon.BASE_DIR.toString(),"server_data").toString());
        configObject.setProperty(ConfigParam.ALLOW_REMOTE_MODULE_INSTALL.getPropertyName(), String.valueOf(false));
    }
}
