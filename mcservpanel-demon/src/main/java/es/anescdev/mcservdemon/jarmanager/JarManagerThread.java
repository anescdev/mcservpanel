package es.anescdev.mcservdemon.jarmanager;

import es.anescdev.mcservdemon.App;
import es.anescdev.mcservdemon.jarmanager.domain.JarManagerRepository;
import es.anescdev.mcspcommons.models.servertype.ServerType;

import java.util.List;
import java.util.logging.Logger;

public class JarManagerThread implements Runnable{
    private static JarManagerThread instance;
    private final JarManagerRepository repo;
    private final Logger logger = App.createLogger(JarManagerThread.class);
    private JarManagerThread(JarManagerRepository repo){
        this.repo = repo;
    }

    public static JarManagerThread getInstance(JarManagerRepository repo){
        if(instance == null) {
            instance = new JarManagerThread(repo);
            instance.logger.info("Created instance.");
        }
        return instance;
    }
    @Override
    public void run() {
        List<ServerType> pendingUpdates = this.repo.checkJarUpgrade();
        if(!pendingUpdates.isEmpty()){
             pendingUpdates.forEach(this.repo::upgradeJar);
        }
    }
}
