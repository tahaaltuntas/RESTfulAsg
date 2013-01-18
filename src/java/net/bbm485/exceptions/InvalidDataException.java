package net.bbm485.exceptions;

import org.codehaus.jettison.json.JSONArray;

public class InvalidDataException extends JSONBasedException {

    public InvalidDataException(JSONArray errorMsg) {
        super(errorMsg, 101, "FieldError");
    }
}
