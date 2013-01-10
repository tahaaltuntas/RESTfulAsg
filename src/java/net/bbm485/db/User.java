package net.bbm485.db;

import com.mongodb.BasicDBObject;

public class User extends  BasicDBObject {
    private String id;
    private String userName;
    private String fullName;
    private String gender;
    private String birthDate;

    
    /*** Getters and Setters ***/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    // TODO : implement json
    /*** End of Getters and Setters ***/
        
    /* can be codded later
    public User(String jsonString) {
        
    }
    * */
    public User(String id, String userName, String fullName, String gender, String birthDate) {
        setId(id);
        setUserName(userName);
        setFullName(fullName);
        setGender(gender);
        setBirthDate(birthDate);
    }
}
