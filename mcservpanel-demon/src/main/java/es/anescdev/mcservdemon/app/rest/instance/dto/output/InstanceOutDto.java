package es.anescdev.mcservdemon.app.rest.instance.dto.output;

import java.util.UUID;

import es.anescdev.mcservdemon.app.rest.jarversion.dto.JarVersionDTO;
import es.anescdev.mcservdemon.context.instance.domain.model.Instance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstanceOutDto {
    private UUID id;
    private String name;
    private JarVersionDTO jarVersion;
    public InstanceOutDto(Instance instance){
        this.id = instance.getId();
        this.name = instance.getName();
        this.jarVersion = new JarVersionDTO(
            instance.getJarVersion().getId().getTag(), 
            instance.getJarVersion().getId().getVersion());
    }
}
