package Toolbox.print;

import static Toolbox.arrayConverter.ArrayList.arrayListTo2dArray;
import static Toolbox.csvMethodes.CsvConverter.csvToStringArrayList;

import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

public class PrintFactory {

  public static void prettyPrintStringArrayList(List<String[]> arrayList) {
    String[][] to2dArray = arrayListTo2dArray(arrayList);
    for (String[] row : to2dArray) {
      for (String rowValue : row) {
        System.out.print(rowValue + " ");
      }
      System.out.println();
    }
  }

  public static void prettyPrintCsv(String path) {
    List<String[]> strings = csvToStringArrayList(path);
    prettyPrintStringArrayList(strings);
  }

  public static void prettyPrintMap(Map<String, String> map) {
    for (Map.Entry<String, String> stringMap : map.entrySet()) {
      System.out.println(stringMap.getKey() + "/" + stringMap.getValue());
    }
  }

  public static void prettyPrintJson(JSONObject jsonObject) {
    String jsonString = jsonObject.toJSONString();
    int counter = 0;
    String[] split = jsonString.substring(1, jsonString.length() - 1).split(",");
    for (String s1 : split) {
      System.out.println(s1);
      counter++;
    }
    System.out.println("--JsonObject has " + counter + " pairs.--");
  }
}
