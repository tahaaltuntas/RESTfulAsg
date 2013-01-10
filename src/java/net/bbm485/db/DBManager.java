package net.bbm485.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {
    private Mongo mongo;
    private DB db;
    private DBCollection collection;
    private String dbName;
    private String collectionName;
    
    public DBManager(String dbName, String collectionName) {
        initializeDB();
    }
     
   private void initializeDB() {
        try {
            mongo = new Mongo();
            db = mongo.getDB(dbName);
            collection = db.getCollection(collectionName);
            
        }
        catch (UnknownHostException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex); // TODO : throw own exception 
       }
        
    }
}
