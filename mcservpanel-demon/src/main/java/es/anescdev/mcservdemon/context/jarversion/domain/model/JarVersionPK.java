package es.anescdev.mcservdemon.context.jarversion.domain.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Embeddable
@Data
@NoArgsConstructor
public class JarVersionPK implements Serializable{
    private String tag;
    private String version;
}
