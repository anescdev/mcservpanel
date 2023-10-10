package es.anescdev.mcservdemon.app.versionspack.command;

import es.anescdev.mcservdemon.app.versionspack.parser.RVersionPackEntry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkCommand extends VersionPackCommand {
    private final Pattern commandPattern = Pattern.compile("^(link \"[a-z\\-A-Z0-9.]+\") (version \\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?) (name \"[\\w\\s\\-.]+\")$");

    public LinkCommand() {
        super("link");
    }

    @Override
    public RVersionPackEntry parseCommand(String command) throws InvalidCommandSyntax {
        Matcher matcher  = this.commandPattern.matcher(command);
        if (!matcher.matches())
            throw new InvalidCommandSyntax("'"+command+"' not valid syntax");
        String jarFile = matcher.group(1);
        String version = matcher.group(2);
        String tag = matcher.group(matcher.groupCount() > 3 ? 4 : 3);
        return new RVersionPackEntry(
                tag.substring(tag.indexOf("\"")+1,tag.lastIndexOf("\"")),
                version.split(" ")[1],
                jarFile.substring(jarFile.indexOf("\"")+1, jarFile.lastIndexOf("\"")));
    }
}
