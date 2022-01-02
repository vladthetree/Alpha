import DB.Mongo.MongoConnection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class main {

  public static void main(String[] args) {

    String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";
    MongoCollection<Document> col = MongoConnection.getCollectionFromDatabase(
        "uat", "bsonObject");

  }

}
