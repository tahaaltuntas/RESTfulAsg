package net.bbm485.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public abstract class JSONBasedException extends Exception {
    protected JSONObject jsonErrorMsg;
    protected String msg;
    protected int errorId;
    protected String errorType;

    public JSONBasedException(JSONArray errorMsg, int errorId, String errorType) {
        msg = "";
        this.errorId = errorId;
        this.errorType = errorType;
        jsonErrorMsg = new JSONObject();
        JSONObject metaPart = new JSONObject();
        try {
            metaPart.put("code", errorId).put("type", errorType);
            metaPart.put("errors", errorMsg);
            jsonErrorMsg.put("meta", metaPart);
            msg = jsonErrorMsg.toString();
            
        }
        catch (JSONException ex) {
        }
        
    }
    
    public JSONBasedException(JSONObject errorMsg, int errorId, String errorType) {
        msg = "";
        this.errorId = errorId;
        this.errorType = errorType;
        jsonErrorMsg = new JSONObject();
        JSONObject metaPart = new JSONObject();
        try {
            metaPart.put("code", errorId).put("type", errorType);
            metaPart.put("errors", errorMsg);
            jsonErrorMsg.put("meta", metaPart);
            msg = jsonErrorMsg.toString();
            
        }
        catch (JSONException ex) {
        }
    }
    
    @Override
    public String getMessage() {
        return msg.isEmpty() ? super.getMessage() : msg;
    }
}
