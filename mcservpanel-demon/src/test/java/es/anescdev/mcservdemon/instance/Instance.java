package es.anescdev.mcservdemon.instance;

import java.io.IOException;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import br.com.azalim.mcserverping.MCPing;
import br.com.azalim.mcserverping.MCPingOptions;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class Instance {

    private static final Logger LOGGER = Logger.getLogger(Instance.class);
    @Test
    public void testGetServerStatus() throws IOException{
        LOGGER.info(MCPing.getPing(MCPingOptions
            .builder()
                .hostname("127.0.0.1")
                .port(25565)
                .build()));
    }
}
