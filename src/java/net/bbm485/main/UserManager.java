package net.bbm485.main;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import com.google.gson.*;
import org.codehaus.jettison.json.JSONObject;

import net.bbm485.exceptions.UserNotFoundException;
import net.bbm485.db.DBManager;
import net.bbm485.db.User;

@Path("users")
public class UserManager {
    private final static String DBNAME = "restful_db";
    private final static String COLLECTION_NAME = "users";
    private final static int INDENT_FACTOR = 4;
    private final static String MEDIA_TYPE = "application/json; charset=UTF-8";
    private DBManager db;
    private Gson gson;
    private JsonFormatter jsonFormatter;

    public UserManager() {
        db = new DBManager(DBNAME, COLLECTION_NAME);
        gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
        jsonFormatter = new JsonFormatter(INDENT_FACTOR);
    }

    @POST
    @Produces(MEDIA_TYPE)
    @Consumes(MEDIA_TYPE)
    public String createUser(String content) {
        User newUser = null;
        try {
            JSONObject userObj = new JSONObject(content).getJSONObject("user");
            newUser = (User) gson.fromJson(userObj.toString(), User.class);
            newUser.checkInfo();
            db.createUser(newUser);
            return jsonFormatter.createSuccessfulMsg("You successfully created a user.");
        }
        catch (Exception e) {
            return jsonFormatter.formatJsonString(e.getMessage());
        }
    }
    
    @GET
    @Produces(MEDIA_TYPE)
    @Path("/{userId}")
    public String showUser(@PathParam("userId") String  userId) {
        try {
            User user = db.getUser(userId);
            return jsonFormatter.showUser(user);
        }
        catch (UserNotFoundException e) {
            return jsonFormatter.formatJsonString(e.getMessage());
        }
    }
    
    @GET
    @Produces(MEDIA_TYPE)
    public String showUserList() {
        List<User> userList = db.getUserList();
        return jsonFormatter.showUserList(userList);
    }
    
    @PUT
    @Produces(MEDIA_TYPE)
    @Consumes(MEDIA_TYPE)
    @Path("/{userId}")
    public String updateUser(@PathParam("userId") String userId, String info) {
        try {
            JSONObject jsonInfo = new JSONObject(info).getJSONObject("user");
            db.updateUser(userId, jsonInfo);
            return jsonFormatter.createSuccessfulMsg("You successfully updated user.");
        }
        catch (Exception e) {
            return jsonFormatter.formatJsonString(e.getMessage());
        }
    }
    
    @DELETE
    @Produces(MEDIA_TYPE)
    @Consumes(MEDIA_TYPE)
    @Path("/{userId}")
    public String deleteUser(@PathParam("userId") String userId) {
        try {
            db.deleteUser(userId);
            return jsonFormatter.createSuccessfulMsg("You successfully deleted the user.");
        }
        catch (Exception e) {
            return jsonFormatter.formatJsonString(e.getMessage());
        }
    }
    
}
