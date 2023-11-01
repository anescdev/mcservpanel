package es.anescdev.mcservdemon.context.jarversion.domain.model;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JarVersion {
    private @Id String tag;
    private String version;
    private File jar;
    @Override
    public boolean equals(Object obj){
        return obj instanceof JarVersion && this.getTag() == ((JarVersion) obj).getTag();
    }
}
