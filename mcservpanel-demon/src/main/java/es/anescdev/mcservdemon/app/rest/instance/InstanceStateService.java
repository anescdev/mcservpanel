package es.anescdev.mcservdemon.app.rest.instance;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import es.anescdev.mcservdemon.context.instance.domain.model.RunningInstance;
import es.anescdev.mcservdemon.context.instance.domain.port.InstancePort;
import es.anescdev.mcservdemon.context.instance.domain.port.InstanceStatePort;
import jakarta.inject.Inject;

public class InstanceStateService {

    @Inject
    private InstanceStatePort instanceStateRepository;

    @Inject
    private InstancePort instanceRepository;
    
    private Map<UUID, RunningInstance> instances = new Hashtable<>();
    // Manejar el EULA
    public boolean startInstance(UUID id){
        if(!instances.containsKey(id)){
            Optional<Instance> instance = instanceRepository.findByIdOptional(id);
            if(instance.isPresent()){
                Optional<RunningInstance> running = instanceStateRepository.startInstance(instance.get());
                if(running.isPresent()){
                    instances.put(id, running.get());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean restartInstance(UUID id){
        if(instances.containsKey(id)){
            return instanceStateRepository.restartInstance(instances.get(id));
        }
        return false;
    }
    
    public boolean stoptInstance(UUID id){
        if(instances.containsKey(id)){
            if(instanceStateRepository.stopInstance(instances.get(id))){
                instances.remove(id);
                return true;
            }
        }
        return false;
    }
}
