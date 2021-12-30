package DB.Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class Connection {

  public static void main(String[] args) {

     String connectionUri =
        "mongodb+srv://Vladthetree:50account@cluster0.9fdym.mongodb.net/test?authSource=admin&replicaSet=atlas-frts2s-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";


    try (MongoClient mongoClient = MongoClients.create(connectionUri)) {

      List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());

      databases.forEach(db -> System.out.println(db.toJson()));

    }

  }

}
