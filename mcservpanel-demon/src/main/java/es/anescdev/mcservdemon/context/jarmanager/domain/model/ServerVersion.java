package es.anescdev.mcservdemon.context.jarmanager.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ServerVersion {
    private final String version;
    @Setter
    private boolean downloaded = false;
    private final String hashMd5;
    public ServerVersion(String version, String hashMd5){
        this.version = version;
        this.hashMd5 = hashMd5;
    }
    public ServerVersion(String version, String hashMd5, boolean downloaded){
        this(version, hashMd5);
        this.downloaded = downloaded;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ServerVersion))
            return false;
        return ((ServerVersion)obj).version.equals(this.version);
    }
}
