package es.anescdev.mcspcommons.models.servertype;

import lombok.Getter;

@Getter
public class ServerType {
    private JarVersion serverVersion;
    private JarType serverType;
    public ServerType(JarVersion serverVersion, JarType serverType){
        this.serverVersion = serverVersion;
        this.serverType = serverType;
    }
}
