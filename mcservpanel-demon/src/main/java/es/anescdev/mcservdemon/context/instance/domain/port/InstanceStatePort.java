package es.anescdev.mcservdemon.context.instance.domain.port;

import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import es.anescdev.mcservdemon.context.instance.domain.model.RunningInstance;

import java.util.Optional;

public interface InstanceStatePort {
    Optional<RunningInstance> startInstance(Instance instance);
    boolean restartInstance(RunningInstance instance);
    boolean stopInstance(RunningInstance instance);
}
