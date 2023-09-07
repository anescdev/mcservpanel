package es.anescdev.mcservdemon;


import com.beust.jcommander.JCommander;
import es.anescdev.mcservdemon.infrastructure.config.commandline.ArgumentConfig;
import es.anescdev.mcservdemon.infrastructure.config.generator.ConfigGenerator;
import es.anescdev.mcservdemon.infrastructure.config.generator.LocalConfigGenerator;
import es.anescdev.mcservdemon.infrastructure.config.strategy.ConfigStrategy;
import es.anescdev.mcservdemon.infrastructure.config.strategy.LocalConfigStrategy;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@QuarkusMain
public class McServDemon implements QuarkusApplication{
    public static final Path BASE_DIR = Paths.get(System.getProperty("user.home"), ".mcservdemon");
    public static final File CONFIG_FILE = new File(BASE_DIR.toFile(),"config.properties");
    ConfigGenerator configGenerator = new LocalConfigGenerator();
    @ApplicationScoped
    ConfigStrategy configStrategy;
    @Override
    public int run(String... args) {
        new LocalConfigGenerator();
        ArgumentConfig arguments = new ArgumentConfig();
        Optional<Integer> resultParse = this.parseArguments(args, arguments);
        if(resultParse.isPresent()) return resultParse.get();
        Optional<Integer> resultConfig = this.createConfig();
        if(resultConfig.isPresent()) return resultConfig.get();
        Quarkus.waitForExit();
        return 0;
    }
    private Optional<Integer> parseArguments(String[] args, ArgumentConfig arguments){
        JCommander jc = JCommander
                .newBuilder()
                .addObject(arguments)
                .build();
        jc.parse(args);
        if(arguments.help){
            jc.usage();
            return Optional.of(0);
        }
        if(arguments.generate){
            if(!configGenerator.generateConfig()){
                return Optional.of(-1);
            }
            return Optional.of(0);
        }
        return Optional.empty();
    }
    private Optional<Integer> createConfig(){
        try {
            this.configStrategy = new LocalConfigStrategy();
        } catch (IOException e) {
            return Optional.of(-1);
        }
        return Optional.empty();
    }
}