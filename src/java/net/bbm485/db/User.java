package net.bbm485.db;

import com.mongodb.BasicDBObject;
import com.google.gson.annotations.SerializedName;

public class User extends  BasicDBObject {
    private String id;
    @SerializedName("username")
    private String userName;
    @SerializedName("fullname")
    private String fullName;
    @SerializedName("gender")
    private String gender;
    @SerializedName("birthDate")
    private String birthDate;

    /*** Getters and Setters ***/
    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
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
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    /*** End of Getters and Setters ***/
    
    public User() { }
    
    public User(String id, String userName, String fullName, String gender, String birthDate) {
        setId(id);
        setFullName(fullName);
        setGender(gender);
        setBirthDate(birthDate);
    }
}
