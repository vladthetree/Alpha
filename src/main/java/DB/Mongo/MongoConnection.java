package DB.Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

  private static final String connectionUri =
      "mongodb+srv://Vladthetree:50account@cluster0.9fdym.mongodb.net/test?authSource=admin&replicaSet=atlas-frts2s-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";

  public static MongoClient connectToMongo() {
    MongoClient mongoClient = null;
    try {
      mongoClient = MongoClients.create(connectionUri);
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

  public static MongoCollection getCollectionFromDatabase(String nameOfDatabase,
      String nameOfCollection) {

    return getDatabase(nameOfDatabase).getCollection(nameOfCollection);
  }


}
