package es.anescdev.mcservdemon.config;

import es.anescdev.mcservdemon.App;
import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.net.URI;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instance;
    private static final String SERVER_JAR_KEY = "ServerJarFolder";
    private static final String SERVER_DATA_KEY = "ServerDataFolder";
    @Getter
    private Path jarFolder;
    private Path serverDataFolder;
    public final File ROOT_FOLDER = new File(System.getProperty("user.home"),".mcservdemon");
    private AppConfig() {
        App.LOGGER.info("Initializing configuration... Please wait.");
        Properties appConfig = new Properties();
        File configFile = new File(ROOT_FOLDER, "config.ini");
        // Si no existe el archivo lo intentamos crear
        if(!configFile.exists()){
            App.LOGGER.config("We can't find the config file, then... We'll create one empty.");
            try{
                configFile.createNewFile();
            }catch (IOException | SecurityException e){
                App.LOGGER.severe("We can't create the file, the program will be finished.");
                System.exit(1);
            }
        }
        //Cargamos la configuración e intentamos leerla.
        try(FileInputStream fis = new FileInputStream(configFile)){
            appConfig.load(fis);
            this.jarFolder = Path.of(appConfig.getProperty(AppConfig.SERVER_JAR_KEY, ROOT_FOLDER.toURI() +"jars"));
            this.serverDataFolder = Path.of(appConfig.getProperty(AppConfig.SERVER_JAR_KEY, ROOT_FOLDER.toURI() +"jars"));
            fis.close();
            if(appConfig.isEmpty()){
                FileOutputStream fos = new FileOutputStream(configFile);
                //TODO: Arreglar para que sea posible un mejor control sin que sea tan estático
            }
        } catch (IOException e) {
            App.LOGGER.severe("We cant read/write the config file, the program will be finished.");
            System.exit(1);
        }
    }

    public Path getServerDataFolder() {
        return serverDataFolder;
    }

    public Path getJarFolder() {
        return jarFolder;
    }

    public static AppConfig getInstance() {
        if(instance==null)
            instance = new AppConfig();
        return instance;
    }
}
