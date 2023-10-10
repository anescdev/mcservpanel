package es.anescdev.mcservdemon.app.versionspack.parser;

import es.anescdev.mcservdemon.app.versionspack.command.LinkCommand;
import es.anescdev.mcservdemon.app.versionspack.command.InvalidCommandSyntax;
import es.anescdev.mcservdemon.app.versionspack.command.VersionPackCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
public class VersionPackParser implements IVersionPackParser {
    private final Set<VersionPackCommand> commandSet;
    public VersionPackParser(){
        this.commandSet = Set.of(new LinkCommand());
    }
    @Override
    public Optional<List<RVersionPackEntry>> parseVersionsPack(File versionsPackFile) {
        try(BufferedReader vpfData = new BufferedReader(new FileReader(versionsPackFile))){
            List<RVersionPackEntry> parsedVpf = new ArrayList<>();
            String actLine = vpfData.readLine();
            if(actLine == null)
                return Optional.empty();
            do{
                Optional<VersionPackCommand> command = this.getCommandHandler(actLine);
                if(command.isPresent())
                    parsedVpf.add(command.get().parseCommand(actLine));
                actLine = vpfData.readLine();
            }while (actLine != null);
            return Optional.of(parsedVpf);
        } catch (IOException e){
            e.printStackTrace();
        } catch (InvalidCommandSyntax e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    private Optional<VersionPackCommand> getCommandHandler(String command){
        final String COMMAND_NAME = command.substring(0,command.indexOf(" "));
        for (VersionPackCommand versionPackCommand: commandSet) {
            if(versionPackCommand.getCommand().equals(COMMAND_NAME))
                return Optional.of(versionPackCommand);
        }
        return Optional.empty();
    }
}
