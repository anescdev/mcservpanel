package es.anescdev.mcservdemon.context.instance.domain.port;

import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import java.util.UUID;

public interface InstancePort extends PanacheRepositoryBase<Instance, UUID>{
    
}
