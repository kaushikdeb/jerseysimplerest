package org.secureworks.pe.jerseysimplerest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.secureworks.pe.jerseysimplerest.Main;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {

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
     * Test to see that a text is converted into md5 hash.
     */
    @Test
    public void testGetMd5() {
        String responseMsg = target.path("md5/ILoveJava").request().get(String.class);
        assertEquals("<html><h2>text=ILoveJava, md5=35454B055CC325EA1AF2126E27707052</h1></html>", responseMsg);
    }
    
    
    /**
     * Test to see that a text is converted into sha hash.
     */
    @Test
    public void testGetSha() {
        String responseMsg = target.path("sha/ILoveJava").request().get(String.class);
        assertEquals("<html><h2>text=ILoveJava, sha=D2F05B425E4D869FD963F32200F7117D69A98A0F</h1></html>", responseMsg);
    }
}
