package no.jpro.timereg;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TimeRegServiceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testRegistrereTimer() {
        List responseMsg = target.path("api/timeregistreringer").queryParam("aar", "2013").request().get(List.class);
        assertEquals(2, responseMsg.size());
    }

    @Test
    public void testFinnRegistrertTimeforing() {
        Timeregistrering timeregistrering = target.path("api/timeregistrering/145").request().get(Timeregistrering.class);
        assertEquals("145", timeregistrering.getId());
    }
}
