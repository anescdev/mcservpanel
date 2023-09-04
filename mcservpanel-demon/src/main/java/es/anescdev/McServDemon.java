package es.anescdev;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


@QuarkusMain
public class McServDemon implements QuarkusApplication {
    public static final Path BASE_DIR = Paths.get(System.getProperty("user.home"), ".mcservdemon");
    public static final File CONFIG_FILE = new File(BASE_DIR.toFile(),"config.properties");
    @Override
    public int run(String... args) {

        Quarkus.waitForExit();
        return 0;
    }
}
