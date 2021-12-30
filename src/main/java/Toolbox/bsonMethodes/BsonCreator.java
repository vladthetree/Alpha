package Toolbox.bsonMethodes;

import Toolbox.csvMethodes.CsvConverter;
import Toolbox.jsonMethodes.JsonConverter;
import Toolbox.jsonMethodes.JsonCreator;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.json.simple.JSONObject;

public class BsonCreator {


  public static Document generateBsonFromCsv(String path, int skip, int columnA, int columnB) {
    List<String[]> strings = CsvConverter.csvToStringArrayList(path).stream().skip(skip).toList();
    Map<String, String> stringStringMap = CsvConverter.mapTwoCsvColumn(strings, columnA, columnB);
    return generateBsonFromMap(stringStringMap);
  }

  public static Document generateBsonFromMap(Map<String, String> map) {
    JSONObject jsonObject = JsonCreator.stringMaptoJsonObject(map);
    return JsonConverter.jsonToBson(jsonObject);
  }

}
