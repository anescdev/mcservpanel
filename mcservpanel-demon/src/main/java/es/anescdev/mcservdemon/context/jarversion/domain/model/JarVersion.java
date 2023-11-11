package es.anescdev.mcservdemon.context.jarversion.domain.model;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JarVersion {
    private @EmbeddedId JarVersionPK id;
    @JsonIgnore
    private File jar;
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof JarVersion)
            return false;
        JarVersion otherJarVersion = (JarVersion) obj;
        return this.getId().getTag() == otherJarVersion.getId().getTag() && this.getId().getVersion() == otherJarVersion.getId().getVersion();
    }
}
