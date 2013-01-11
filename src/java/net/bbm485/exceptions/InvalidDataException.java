package net.bbm485.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InvalidDataException extends JSONBasedException {

    public InvalidDataException(JSONArray errorMsg) {
        super(errorMsg, 101, "FieldError");
    }
}
