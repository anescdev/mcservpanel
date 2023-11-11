package es.anescdev.mcservdemon.app.rest.instance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import es.anescdev.mcservdemon.app.rest.instance.dto.in.InstanceDto;
import es.anescdev.mcservdemon.app.rest.instance.dto.in.InstanceUpdateDto;
import es.anescdev.mcservdemon.app.rest.instance.dto.output.InstanceOutDto;
import es.anescdev.mcservdemon.app.rest.validation.Validator;
import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces
@Path("/instance")
public class InstanceResource {

    @Inject
    Validator<InstanceDto> instanceDtoValidator;

    @Inject
    InstanceService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createInstance(InstanceDto instanceData){
        Optional<Response> errResponse = instanceDtoValidator.validate(instanceData);
        if(errResponse.isPresent())
            return errResponse.get();
        return Response.status(201).entity(new InstanceOutDto(service.create(instanceData))).build();
    }

    @DELETE
    @Transactional
    public Response deleteInstance(@QueryParam("id") UUID id){
        return Response.status(service.delete(id)? 200 : 404).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateInstance(InstanceUpdateDto instanceData){
        try {
            service.update(instanceData);
            return Response.ok().build();
        } catch (NotFoundException e) {
            return Response.status(404).build();
        }
    }
    
    @GET
    public Response getInstances(){
        List<Instance> instances = service.searchAll();
        if(instances.isEmpty())
            return Response.status(404).build();
        return Response.status(200).entity(instances.stream().map(instance->new InstanceOutDto(instance))).build();
    }
}
