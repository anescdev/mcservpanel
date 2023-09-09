package es.anescdev.mcspapi.module;

import lombok.Getter;

@Getter
public abstract class ModuleInfo {
    private final String id,
            name,
            description,
            author,
            webPage;
    public ModuleInfo(String id, String name, String description, String author, String webPage){
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.webPage = webPage;
    }
}
