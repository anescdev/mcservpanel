package es.anescdev.mcservdemon.rest.endpoints;

import es.anescdev.mcservdemon.rest.dto.ServerInfoDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class ServerResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerInfoDto getInstanceInfo(){
        return new ServerInfoDto(
                false,
                new int[]{1},
                new int[]{});
    }
}
