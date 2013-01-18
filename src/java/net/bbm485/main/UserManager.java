package net.bbm485.main;

import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

import net.bbm485.db.DBManager;
import net.bbm485.db.User;
import org.codehaus.jettison.json.JSONObject;
import com.google.gson.*;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import net.bbm485.exceptions.UserNotFoundException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

@Path("users")
public class UserManager {
    private final static String dbName = "restful_db";
    private final static String collectionName = "users";
    private DBManager db;
    private Gson gson;

    public UserManager() {
        db = new DBManager(dbName, collectionName);
        gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    }

    @POST
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    public String createUser(String content) {
        User newUser = null;
        try {
            JSONObject userObj = new JSONObject(content).getJSONObject("user");
            newUser = (User) gson.fromJson(userObj.toString(), User.class);
            newUser.checkInfo();
            db.createUser(newUser);
            return getSuccessfulMsg("You successfully created a user.");
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/{userId}")
    public String showUser(@PathParam("userId") String  userId) {
        JSONObject result = new JSONObject();
        try {
            User user = db.getUser(userId);
            // TODO : make 200 final static
            result.put("meta", (new JSONObject()).put("code", 200));
            result.put("data", user.toJson());
            return result.toString().replace("\\\"", "\"");
        }
        catch (UserNotFoundException e) {
            return e.getMessage();
        }
        catch (JSONException e) {
            return e.getMessage();
        }
    }
    
    @GET
    @Produces("application/json; charset=UTF-8")
    public String showUserList() {
        JSONObject result = new JSONObject();
        List<User> userList = db.getUserList();
        try {
            result.put("meta", (new JSONObject()).put("code", 200));
            JSONArray data = new JSONArray();
            for (User user : userList)
                data.put(new JSONObject(user.toJson()));
            result.put("data", userList.size() == 0 ? JSONObject.NULL : data);
            return result.toString();
        }
        catch (JSONException e) {
            return "";
        }
    }
    
    @PUT
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/{userId}/") // TODO: delete last ch
    public String updateUser(@PathParam("userId") String userId, String info) {
        // TODO : arrange exceptions
  
        try {
            JSONObject jsonInfo = new JSONObject(info).getJSONObject("user");
            db.updateUser(userId, jsonInfo);
            return getSuccessfulMsg("You successfully updated user.");
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @DELETE
    @Produces("application/json; charset=UTF-8")
    @Consumes("application/json; charset=UTF-8")
    @Path("/{userId}")
    public String deleteUser(@PathParam("userId") String userId) {
        try {
            db.deleteUser(userId);
            return getSuccessfulMsg("You successfully deleted the user.");
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    private String getSuccessfulMsg(String msg) {
        // TODO : convert other successful messages
        JSONObject msgObj = new JSONObject();
        try {
            msgObj.put("meta", (new JSONObject()).put("code", 200));
            msgObj.put("data", (new JSONObject()).put("message", msg));
        }
        catch (JSONException e) {
        }
        return msgObj.toString();
    }
}
