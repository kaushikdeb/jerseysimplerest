package org.secureworks.pe.jerseysimplerest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "md5" path)
 */
@Path("/")
public class MyHashingResource {

    /**
     * Method handling HTTP GET /md5/{text} requests. The returned object will be sent
     * to the client as "text/html" media type, with the md5 hash.
     *
     * @return String representation of md5 hash of text passed in path.
     */
    @GET
    @Path("md5/{text}")
    @Produces(MediaType.TEXT_HTML)
    public String getMd5(@PathParam("text") String text) {
        return "<html><h2>text=" + text + ", md5=" + TextToHash.getMd5forText(text) +"</h1></html>";
    }
    
    
    /**
     * Method handling HTTP GET /sha/{text} requests. The returned object will be sent
     * to the client as "text/html" media type, with the md5 hash.
     *
     * @return String representation of sha hash of text passed in path.
     */
    @GET
    @Path("sha/{text}")
    @Produces(MediaType.TEXT_HTML)
    public String getSha(@PathParam("text") String text) {
        return "<html><h2>text=" + text + ", sha=" + TextToHash.getShaforText(text) +"</h1></html>";
    }
    
    
}
