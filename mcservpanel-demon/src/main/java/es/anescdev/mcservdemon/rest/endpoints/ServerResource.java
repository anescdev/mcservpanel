package es.anescdev.mcservdemon.rest.endpoints;

import es.anescdev.mcservdemon.infrastructure.config.strategy.ConfigStrategy;
import es.anescdev.mcservdemon.rest.dto.ServerInfoDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class ServerResource {

    @Inject
    ConfigStrategy configStrategy;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerInfoDto getInstanceInfo(){
        return new ServerInfoDto(
                configStrategy.instanceName(),
                new int[]{1}
        );
    }
}
