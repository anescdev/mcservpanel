package es.anescdev.mcservdemon.versionpack;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@QuarkusTest
public class VersionPackTest {
    private final Pattern commandPattern = Pattern.compile("^(link \"[a-z\\-A-Z0-9.]+\") (version \\d{1,2}\\.\\d{1,2}(\\.\\d{1,2})?) (name \"[\\w\\-.]+\")$");
    @Test
    public void testParseCommand(){
        String command = "link \"test.jar\" version 1.20.3 name \"juan\"";
        Matcher matcher = this.commandPattern.matcher(command);
        Assertions.assertTrue(matcher.matches());
        String jarFile = matcher.group(1);
        String version = matcher.group(2);
        String tag = matcher.group(matcher.groupCount() > 3 ? 4 : 3);
        System.out.println(jarFile.substring(jarFile.indexOf("\"")+1,jarFile.lastIndexOf("\"")));
        System.out.println(version.split(" ")[1]);
        System.out.println(tag.substring(tag.indexOf("\"")+1,tag.lastIndexOf("\"")));
    }

}
