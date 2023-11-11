package es.anescdev.mcservdemon.context.instance.adapter;

import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import es.anescdev.mcservdemon.context.instance.domain.model.RunningInstance;
import es.anescdev.mcservdemon.context.instance.domain.port.InstanceStatePort;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Optional;

@ApplicationScoped
public class InstanceStateAdapter implements InstanceStatePort {
    @Override
    public Optional<RunningInstance> startInstance(Instance instance) {
        ProcessBuilder runningInstanceBuilder = new ProcessBuilder();
        runningInstanceBuilder.directory(instance.getServerData());
        runningInstanceBuilder.command("java", "-jar", instance.getJarVersion().getJar().getAbsolutePath(), "--nogui");
        try {
            return Optional.of(new RunningInstance(runningInstanceBuilder.start()));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean restartInstance(RunningInstance instance) {
        return this.sendCommand(instance, "restart");
    }

    @Override
    public boolean stopInstance(RunningInstance instance) {
        return this.sendCommand(instance, "stop");
    }
    private boolean sendCommand(RunningInstance instance, String command){
        try(DataOutputStream serverCli = new DataOutputStream(instance.getRunningProcess().getOutputStream())){
            serverCli.writeBytes(command);
            return serverCli.size() == command.length();
        } catch(IOException e){
            return false;
        }
    }
}
