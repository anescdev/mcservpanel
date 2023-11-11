package es.anescdev.mcservdemon.app.rest.instance.validation;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import es.anescdev.mcservdemon.app.rest.instance.dto.in.InstanceDto;
import es.anescdev.mcservdemon.app.rest.validation.ErrorDTO;
import es.anescdev.mcservdemon.app.rest.validation.Validator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class InstanceDtoValidator implements Validator<InstanceDto>{

    @Override
    public Optional<Response> validate(InstanceDto object) {
        List<ErrorDTO> errorDTOList = new LinkedList<>();
        if(object.getName()!=null && object.getName().isEmpty())
            errorDTOList.add(new ErrorDTO("The name cannot be empty or undefined", "name"));
        return Validator.prepareResponse(errorDTOList);
    }
    
}
