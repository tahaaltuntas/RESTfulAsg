package net.bbm485.main;

import java.util.List;
import net.bbm485.db.User;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonFormatter {
    private final static int SUCCESS_CODE = 200;
    private final static String META_TAG = "meta";
    private final static String DATA_TAG = "data";
    private final static String CODE_TAG = "code";
    private final static String MESSAGE_TAG = "message";
    
    public String createSuccessfulMsg(String msg) {
        JSONObject msgObj = new JSONObject();
        try {
            msgObj.put(META_TAG, (new JSONObject()).put(CODE_TAG, SUCCESS_CODE));
            msgObj.put(DATA_TAG, (new JSONObject()).put(MESSAGE_TAG, msg));
        }
        catch (JSONException e) {
        }
        return msgObj.toString();
    }
    
    public String showUser(User user) {
        try {
            JSONObject result = new JSONObject();
            result.put("meta", (new JSONObject()).put("code", 200));
            result.put("data", user.toJson());
            return result.toString().replace("\\\"", "\"");
        }
        catch (JSONException e) {
            return e.getMessage();
        }
    }
    
    public String showUserList(List<User> userList) {
        JSONObject result = new JSONObject();
        try {
            result.put("meta", (new JSONObject()).put("code", 200));
            JSONArray data = new JSONArray();
            for (User user : userList)
                data.put(new JSONObject(user.toJson()));
            result.put("data", userList.isEmpty() ? JSONObject.NULL : data);
            return result.toString();
        }
        catch (JSONException e) {
            return "";
        }
    }
}
