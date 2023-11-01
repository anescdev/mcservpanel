package es.anescdev.mcservdemon.app.rest.jarversion;

import es.anescdev.mcservdemon.app.rest.validation.Validator;
import es.anescdev.mcservdemon.app.rest.jarversion.dto.JarVersionDTO;
import es.anescdev.mcservdemon.context.jarversion.adapter.JarVersionAdapter;
import es.anescdev.mcservdemon.context.jarversion.domain.port.JarVersionPort;

import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Produces
@Path("/version")
public class JarVersionResource {
    JarVersionPort jarVersionPort = JarVersionAdapter.getInstance();
    @Inject
    Validator<JarVersionDTO> validator;
    @GET
    public Response getAllVersions(@BeanParam JarVersionDTO params){
        Optional<Response> validation = validator.validate(params);
        if(validation.isPresent())
            return validation.get();
        List<JarVersionDTO> resContent;
        if(params.getVersion() != null && params.getTag() != null)
            resContent = jarVersionPort.getJarVersions(params.getTag(), params.getVersion())
                    .stream()
                    .map(rJarVersion ->
                            new JarVersionDTO(rJarVersion.getTag(), rJarVersion.getVersion()))
                    .toList();
        else if(params.getVersion() != null)
            resContent = jarVersionPort.getJarVersionsByVersion(params.getVersion())
                    .stream()
                    .map(rJarVersion ->
                            new JarVersionDTO(rJarVersion.getTag(), rJarVersion.getVersion()))
                    .toList();
        else if(params.getTag() != null)
            resContent = jarVersionPort.getJarVersionsByTag(params.getTag())
                    .stream()
                    .map(rJarVersion ->
                            new JarVersionDTO(rJarVersion.getTag(), rJarVersion.getVersion()))
                    .toList();
        else
            resContent =  jarVersionPort.getJarVersions()
                    .stream()
                    .map(rJarVersion ->
                            new JarVersionDTO(rJarVersion.getTag(), rJarVersion.getVersion()))
                    .toList();
        if(resContent.isEmpty())
            return Response.status(404).build();
        return Response.ok(resContent).build();
    }
}
