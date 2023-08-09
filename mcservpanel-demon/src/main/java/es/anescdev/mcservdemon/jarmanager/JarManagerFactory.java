package es.anescdev.mcservdemon.jarmanager;

import es.anescdev.mcservdemon.jarmanager.config.JarManagerType;
import es.anescdev.mcservdemon.jarmanager.model.JarManagerRepository;

public class JarManagerFactory {
    public JarManagerRepository createJarFactory(JarManagerType jarManagerType) throws NotSupportedManager{
        switch (jarManagerType){
            case SERVER_JARS:
                return new ServerJarJarManager();
            default:
                throw new NotSupportedManager("No has pasado un tipo existente");
        }
    }
}
