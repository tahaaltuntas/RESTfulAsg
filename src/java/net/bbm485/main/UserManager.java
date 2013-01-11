package net.bbm485.main;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import net.bbm485.db.DBManager;
import net.bbm485.db.User;
import org.codehaus.jettison.json.JSONObject;
import com.google.gson.*;

@Path("users")
public class UserManager {
    @Context
    private UriInfo context;
    private final static String dbName = "restful_db";
    private final static String collectionName = "users";
    private DBManager db;
    private Gson gson;
    public UserManager() {
        db = new DBManager(dbName, collectionName);
        gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        return "bok";
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String createUser(String content) {
        User newUser = null;
        try {
            JSONObject userObj = new JSONObject(content).getJSONObject("user");
            newUser = (User) gson.fromJson(userObj.toString(), User.class);
            System.out.println("bok sicccc");
            System.out.println(newUser.getUsername());
            newUser.checkData();
            return userObj.toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
