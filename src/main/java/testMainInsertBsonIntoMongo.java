import DB.Mongo.MongoConnection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class testMainInsertBsonIntoMongo {

  public static void main(String[] args) {
    String path = "C://Users//vlady//Documents//TestFiles//A//TextCSV.csv";
    MongoCollection<Document> col = MongoConnection.getCollectionFromDatabase(
        "uat", "bsonObject");

    /*
    adds csv to Mongo by using the path
     */
//    Document document = BsonCreator.generateBsonFromCsv(path, 4, 1, 3);
//    BsonObject bsonObject = new BsonObject("TestName", "testi", document);
//    Document document2 = MongoConnection.insertBsonObject(bsonObject);
//    MongoConnection.getCollectionFromDatabase("uat", "bsonObject").insertOne(document2);

    //-------------------------------------------------------------------------------------------
    /*
    generation of Bson Documents
     */

//    Document doc = new Document("id", 1);
//    doc.put("keyName", "valueName");
//    ArrayList<Document> scores = new ArrayList<>();
//    for (int i = 0; i < 10; i++) {
//      scores.add(new Document("score", 90 + i).append("type", "exam_" + i));
//    }
//    Document doc2 = new Document("id", 2);
//    doc.put("keyName", "valueName2");
//    for(int i = 0; i<10;i++){
//      doc2.put("spezialKeyName_"+(i+1),"spezialValueName_"+(i+1));
//    }
//    doc.append("scores", scores);
//    col.insertOne(doc);
//    col.insertOne(doc2);
    //-------------------------------------------------------------------------------------------

//    /*
//    getting Data from Mongo, Only One Result
//     */
//     Document doc = new Document("id", 1);
//    Bson filter = doc;
//    Document result = col.find(filter).first();
    //-------------------------------------------------------------------------------------------

//    /*
//    Get multiple Results
//     */
//    Document doc = new Document("id", 1);
//    Bson filter = doc;
//    ArrayList<Document>documentArrayList = col.find(doc).into(new ArrayList<>());

  }
}