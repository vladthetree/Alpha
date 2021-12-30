package Toolbox.json_Methodes;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonFactory {

  private static void addCountedArraysToJsonObject(JSONObject jsonObject, String declaration,
      int amount) {
    Map<String, String> linkedHashMap = new LinkedHashMap<>(amount);

    for (int i = 0; i < amount; i++) {
      linkedHashMap.put("name_" + (i + 1) + "_" + declaration,
          "value_" + (i + 1) + "_" + declaration); // i wird iteriert weil, lHashmap unique ist
    }
    JSONArray jsonArray = new JSONArray();
    jsonArray.add(linkedHashMap);
    jsonObject.put(declaration, jsonArray);

  }
}
