package DB.Mongo;

import static Toolbox.jsonMethodes.JsonConverter.jsonToBson;

import DB.Mongo.model.BsonObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.simple.JSONObject;

public class MongoConnection {

  private static final String connectionUri =
      "mongodb+srv://Vladthetree:50account@cluster0.9fdym.mongodb.net/test?authSource=admin&replicaSet=atlas-frts2s-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";

  public static MongoClient connectToMongo() {
    MongoClient mongoClient = null;
    try {
      mongoClient = MongoClients.create(connectionUri);
      MongoDatabase uat = mongoClient.getDatabase("uat");
    } catch (Exception e) {
      System.out.println("MongoConnection -> connectToMongo() - Connection failed. " + e);
    }
    System.out.println("Connection to Mongo successful.");
    return mongoClient;
  }

  public static MongoDatabase getDatabase(String nameOfDatabase) {
    MongoDatabase database = connectToMongo().getDatabase(nameOfDatabase);
    return database;
  }

  public static MongoCollection<Document> getCollectionFromDatabase(String nameOfDatabase,
      String nameOfCollection) {
    return getDatabase(nameOfDatabase).getCollection(nameOfCollection);
  }

  public static Document insertBsonObject(BsonObject bsonObject){
    JSONObject jsonObject = new JSONObject();
    String fsName = bsonObject.getFsName();
    String internalNickname = bsonObject.getInternalNickname();
    jsonObject.put("name",fsName);
    jsonObject.put("internalNickname",internalNickname);
    jsonObject.put("bson",bsonObject.getBsonfile());

    return jsonToBson(jsonObject);
  }


}



