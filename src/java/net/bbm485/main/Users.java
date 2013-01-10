/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bbm485.main;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author tahaa
 */
@Path("users")
public class Users {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Users
     */
    public Users() {
    }

    /**
     * Retrieves representation of an instance of net.bbm485.main.Users
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        return "bok";
    }

    /**
     * PUT method for updating or creating an instance of Users
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
}
