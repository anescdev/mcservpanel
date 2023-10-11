package es.anescdev.mcservdemon.app.rest.jarversion.dto;

import jakarta.ws.rs.QueryParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JarVersionDTO {
    private @QueryParam("tag") String tag;
    private @QueryParam("version") String version;
}
