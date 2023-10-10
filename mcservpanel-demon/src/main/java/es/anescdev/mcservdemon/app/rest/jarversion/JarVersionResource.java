package es.anescdev.mcservdemon.app.rest.jarversion;

import es.anescdev.mcservdemon.app.rest.jarversion.dto.RJarVersionDTO;
import es.anescdev.mcservdemon.context.jarversion.adapter.JarVersionAdapter;
import es.anescdev.mcservdemon.context.jarversion.domain.port.JarVersionPort;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Produces
@Path("/version")
public class JarVersionResource {
    JarVersionPort jarVersionPort = JarVersionAdapter.getInstance();

    @GET
    public List<RJarVersionDTO> getAllVersions(
            @QueryParam("version") String version,
            @QueryParam("tag") String tag){
        //TODO: Falta validación
        if(version != null && tag != null)
            return jarVersionPort.getJarVersions(tag, version)
                    .stream()
                    .map(rJarVersion ->
                            new RJarVersionDTO(rJarVersion.tag(), rJarVersion.version()))
                    .toList();
        if(version != null)
            return jarVersionPort.getJarVersionsByVersion(version)
                    .stream()
                    .map(rJarVersion ->
                            new RJarVersionDTO(rJarVersion.tag(), rJarVersion.version()))
                    .toList();
        if(tag != null)
            return jarVersionPort.getJarVersionsByTag(tag)
                    .stream()
                    .map(rJarVersion ->
                            new RJarVersionDTO(rJarVersion.tag(), rJarVersion.version()))
                    .toList();
        return jarVersionPort.getJarVersions()
                .stream()
                .map(rJarVersion ->
                        new RJarVersionDTO(rJarVersion.tag(), rJarVersion.version()))
                .toList();
    }
}
