package es.anescdev.mcservdemon.app.rest.instance.dto.in;

import java.util.UUID;

import es.anescdev.mcservdemon.app.rest.jarversion.dto.JarVersionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InstanceUpdateDto{
    @NonNull
    private UUID id;
    private String name;
    private JarVersionDTO version;
}