package es.anescdev.mcservdemon.app.versionspack.command;

import es.anescdev.mcservdemon.app.versionspack.parser.RVersionPackEntry;

import lombok.Getter;

@Getter
public abstract class VersionPackCommand {
    private final String command;
    public VersionPackCommand(String command){
        this.command = command;
    }
    public abstract RVersionPackEntry parseCommand(String command) throws InvalidCommandSyntax;
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof VersionPackCommand))
            return false;
        return ((VersionPackCommand) obj).command.equals(this.command);
    }
}
