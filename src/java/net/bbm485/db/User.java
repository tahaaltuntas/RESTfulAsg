package net.bbm485.db;

import com.mongodb.BasicDBObject;

public class User extends  BasicDBObject {
    public String id;
    public String username;
    public String fullname;
    public String gender;
    public String birthDate;
    
    public User() { }
    
    public User(String id, String userName, String fullName, String gender, String birthDate) {
        this.id = id;
        this.username = userName;
        this.fullname = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
