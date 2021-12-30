package Toolbox.json_Methodes;

import org.bson.Document;
import org.json.simple.JSONObject;

public class JsonConverter {

  public static Document jsonToBson(JSONObject jsonObject) {
    return Document.parse(jsonObject.toJSONString());
  }
}
