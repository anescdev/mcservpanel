package es.anescdev.mcservdemon.app.rest.instance;

import java.io.File;
import java.util.List;
import java.util.UUID;

import es.anescdev.mcservdemon.McServDemon;
import es.anescdev.mcservdemon.app.rest.instance.dto.in.InstanceDto;
import es.anescdev.mcservdemon.app.rest.instance.dto.in.InstanceUpdateDto;
import es.anescdev.mcservdemon.context.instance.domain.model.Instance;
import es.anescdev.mcservdemon.context.instance.domain.port.InstancePort;
import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersion;
import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersionPK;
import es.anescdev.mcservdemon.context.jarversion.domain.port.JarVersionPort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class InstanceService {
    @Inject
    InstancePort instanceRepository;
    @Inject
    JarVersionPort versionRepository;
    
    List<Instance> searchAll(){
        return instanceRepository.listAll();
    }
    Instance create(InstanceDto instanceData){
        Instance instance = new Instance(
            null, 
            instanceData.getName(), versionRepository.findById(new JarVersionPK(instanceData.getVersion().getTag(), 
            instanceData.getVersion().getVersion())), 
            null, 
            null);
        instanceRepository.persist(instance);
        instance.setServerData(new File(McServDemon.SERVER_DATA.toFile(),instance.getId().toString()));
        System.out.println(instance);
        return instance;
    }
    void update(InstanceUpdateDto instanceData){
        Instance instance = instanceRepository.findById(instanceData.getId());
        if(instance == null)
            throw new NotFoundException();
        if(instanceData.getName() != null && 
            !instanceData.getName().equals(instance.getName()))
                instance.setName(instanceData.getName());
        if(instanceData.getVersion()!=null){
            JarVersion jarVersion = versionRepository.findById(new JarVersionPK(instanceData.getVersion().getTag(), instanceData.getVersion().getVersion()));
            if(instance.getJarVersion() != jarVersion)
                instance.setJarVersion(jarVersion);
        }
    }
    boolean delete(UUID id){
        return instanceRepository.deleteById(id);
    }
}
