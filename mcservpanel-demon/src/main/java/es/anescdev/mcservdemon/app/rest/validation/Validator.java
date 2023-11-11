package es.anescdev.mcservdemon.app.rest.validation;


import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

public interface Validator<T> {
    Optional<Response> validate(T object);
    static Optional<Response> prepareResponse(List<ErrorDTO> errorDTOList){
        if(!errorDTOList.isEmpty())
            return Optional.of(Response.status(400).entity(errorDTOList).build());
        return Optional.empty();
    }
}
