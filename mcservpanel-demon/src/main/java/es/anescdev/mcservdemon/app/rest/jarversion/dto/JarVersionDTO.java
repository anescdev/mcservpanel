package es.anescdev.mcservdemon.app.rest.jarversion.dto;

import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersion;
import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class JarVersionDTO{
    private @QueryParam("tag") @NonNull String tag;
    private @QueryParam("version") @NonNull String version;
    public JarVersionDTO(JarVersion jarVersion){
        this.tag = jarVersion.getId().getTag();
        this.version = jarVersion.getId().getVersion();
    }
}
