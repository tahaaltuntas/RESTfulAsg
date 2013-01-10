package net.bbm485.main;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("users")
public class Users {
    @Context
    private UriInfo context;
    public Users() {
    }

    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        return "bok";
    }

    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
}
