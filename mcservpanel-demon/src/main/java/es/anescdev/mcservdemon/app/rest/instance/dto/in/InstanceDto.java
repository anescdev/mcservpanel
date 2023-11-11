package es.anescdev.mcservdemon.app.rest.instance.dto.in;

import es.anescdev.mcservdemon.app.rest.jarversion.dto.JarVersionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InstanceDto{
    private String name;
    private JarVersionDTO version;
}
