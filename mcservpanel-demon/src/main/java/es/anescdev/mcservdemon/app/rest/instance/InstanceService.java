package es.anescdev.mcservdemon.app.rest.instance;

import java.util.List;

import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import es.anescdev.mcservdemon.context.instance.domain.port.InstancePort;
import es.anescdev.mcservdemon.context.instance.domain.port.InstanceStatePort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InstanceService {
    @Inject
    InstancePort instanceRepository;
    @Inject
    InstanceStatePort instanceStateRepo;

    List<Instance> searchAll(){
        return instanceRepository.listAll();
    }
}
