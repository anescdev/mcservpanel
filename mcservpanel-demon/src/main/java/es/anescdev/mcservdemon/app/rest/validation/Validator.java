package es.anescdev.mcservdemon.app.rest.validation;


import jakarta.ws.rs.core.Response;

import java.util.Optional;

public interface Validator<T> {
    Optional<Response> validate(T object);
}
