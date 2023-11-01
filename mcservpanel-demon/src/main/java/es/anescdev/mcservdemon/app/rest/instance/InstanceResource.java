package es.anescdev.mcservdemon.app.rest.instance;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces
@Path("/instance")
public class InstanceResource {

    @Inject
    InstanceService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createInstance(){
        return Response.status(200).entity("Eaeaea").build();
    }
    
    @GET
    public Response getInstances(){
        return Response.status(200).entity(service.searchAll()).build();
    }
}
