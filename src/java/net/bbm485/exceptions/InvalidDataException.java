package net.bbm485.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InvalidDataException extends Exception {
    private JSONObject jsonErrorMsg;
    private String msg;

    public InvalidDataException(JSONArray errorMsg) {
        msg = "";
        jsonErrorMsg = new JSONObject();
        JSONObject metaData = new JSONObject();
        try {
            metaData.put("code", "101").put("type", "FieldError");
            metaData.put("errors", errorMsg);
            jsonErrorMsg.put("meta", metaData);
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
