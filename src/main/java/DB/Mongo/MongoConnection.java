package DB.Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

  private static final String connectionUri =
      "mongodb+srv://Vladthetree:50account@cluster0.9fdym.mongodb.net/test?authSource=admin&replicaSet=atlas-frts2s-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";

  public static MongoClient connectToMongo() {
    return MongoClients.create(connectionUri);
  }

  public static MongoDatabase getDatabase(String nameOfDatabase) {
    return connectToMongo().getDatabase(nameOfDatabase);
  }

  public static MongoCollection getCollectionFromDatabase(String nameOfDatabase,
      String nameOfCollection) {
    return getDatabase(nameOfDatabase).getCollection(nameOfCollection);
  }


}
