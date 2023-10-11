package es.anescdev.mcservdemon.app.rest.jarversion.validator;

import es.anescdev.mcservdemon.app.rest.validation.ErrorDTO;
import es.anescdev.mcservdemon.app.rest.validation.Validator;
import es.anescdev.mcservdemon.app.rest.jarversion.dto.JarVersionDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@ApplicationScoped
public class JarVersionValidator implements Validator<JarVersionDTO> {
    private final Pattern PATTERN = Pattern.compile("^\\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?$");
    @Override
    public Optional<Response> validate(JarVersionDTO object) {
        List<ErrorDTO> errorDTOList = new LinkedList<>();
        if(object.getVersion() != null && !this.PATTERN.matcher(object.getVersion()).matches())
            errorDTOList.add(new ErrorDTO("The version format is invalid", "version"));
        if(object.getTag() != null && object.getTag().isBlank())
            errorDTOList.add(new ErrorDTO("The tag is blank", "tag"));
        if(!errorDTOList.isEmpty())
            return Optional.of(Response.status(400).entity(errorDTOList).build());
        return Optional.empty();
    }
}
