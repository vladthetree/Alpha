package Toolbox.jsonMethodes;

import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonCreator {

  private static JSONObject jsonObject = new JSONObject();


  public static JSONObject createJsonByPath(String path) {
    JSONParser jsonParser = new JSONParser();
    try {
      jsonObject = (JSONObject) jsonParser.parse(path);
    } catch (ParseException e) {
      System.out.println("JsonCreator -> createJsonByPath() - " + path + " could not be parsed.");
    }
    return jsonObject;

  }

  public static JSONObject stringMaptoJsonObject(Map<String, String> stringMap) {
    for (Map.Entry<String, String> stringEntry : stringMap.entrySet()) {
      jsonObject.put(stringEntry.getKey(), stringEntry.getValue());
    }
    return jsonObject;
  }
}
