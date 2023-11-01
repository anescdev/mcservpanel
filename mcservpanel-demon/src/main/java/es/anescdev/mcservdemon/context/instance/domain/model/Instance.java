package es.anescdev.mcservdemon.context.instance.domain.model;

import es.anescdev.mcservdemon.context.jarversion.domain.model.JarVersion;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Instance{
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private JarVersion jarVersion;
    private File serverData;
    private LocalDateTime lastStart;
    public Instance(@NonNull UUID id, @NonNull String name, @NonNull JarVersion jarVersion, @NonNull File serverData, LocalDateTime lastStart){
        this.id = id;
        this.name = name;
        this.jarVersion = jarVersion;
        this.serverData = serverData;
        this.lastStart = lastStart;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setJarVersion(@NonNull JarVersion jarVersion) {
        this.jarVersion = jarVersion;
    }

    public void setLastStart(@NonNull LocalDateTime lastStart) {
        this.lastStart = lastStart;
    }
}

