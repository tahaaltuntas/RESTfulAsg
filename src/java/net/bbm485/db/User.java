package net.bbm485.db;

import com.mongodb.BasicDBObject;
import com.google.gson.annotations.SerializedName;
import net.bbm485.exceptions.InvalidDataException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class User {

    private String id;
    
    private String username;
    @SerializedName("fullname")
    private String fullName;
    @SerializedName("gender")
    private String gender;
    @SerializedName("birthDate")
    private String birthDate;

    /**
     * * Getters and Setters **
     */
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }

    public void setUsername(String username) {
        this.username = username == null ? "" : username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? "" : fullName;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? "" : gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate == null ? "" : birthDate;
    }

    /**
     * * End of Getters and Setters **
     */
    public User() { }

    public User(String id, String userName, String fullName, String gender, String birthDate) {
        setId(id);
        setUsername(userName);
        setFullName(fullName);
        setGender(gender);
        setBirthDate(birthDate);
    }
    
    public void checkData() throws InvalidDataException {
        JSONArray errMsg = new JSONArray();
        JSONObject errObj = null;
        try {
            if (isNullorEmpty(username)) {
                errObj = new JSONObject();
                errObj.put("fieldName", "username");
                errObj.put("rejectedValue", JSONObject.NULL);
                errMsg.put(errObj);
                //System.out.println(username);
            }
            if (isNullorEmpty(fullName)) {
                errObj = new JSONObject();
                errObj.put("fieldName", "fullname");
                errObj.put("rejectedValue", JSONObject.NULL);
                errMsg.put(errObj);
            }
            if (isNullorEmpty(gender)) {
                errObj = new JSONObject();
                errObj.put("fieldName", "gender");
                errObj.put("rejectedValue", JSONObject.NULL);
                errMsg.put(errObj);
            }
            if (isNullorEmpty(birthDate)) {
                errObj = new JSONObject();
                errObj.put("fieldName", "birthDate");
                errObj.put("rejectedValue", JSONObject.NULL);
                errMsg.put(errObj);
                //System.out.println(birthDate);
            }
            if (errMsg.length() != 0)
                throw new InvalidDataException(errMsg);
        }
        catch (JSONException e) {
            
        }
            
            
    }
    
    private boolean isNullorEmpty(String str) {
        return str == null || str.isEmpty() ? true : false;
    }
}
