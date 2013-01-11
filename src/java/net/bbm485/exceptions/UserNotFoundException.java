package net.bbm485.exceptions;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class UserNotFoundException extends JSONBasedException {

    public UserNotFoundException(JSONObject errorMsg) {
        super(errorMsg, 102, "NotFoundError");
    }
}