package Toolbox.csv_Methodes;

import static Toolbox.arrayConverter.ArrayList.arrayListTo2dArray;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvConverter {

  public static Reader getPathReader(String path) {
    Reader reader = null;
    try {
      reader = new FileReader(path);
    } catch (FileNotFoundException e) {
      System.out.println(
          "CSV_Reader -> getFile() - File could not be found. Path " + path + " is not right. "
              + e);
    }
    return reader;
  }

  public static List<String[]> readerToStringArrayList(Reader reader) {
    CSVReader read = new CSVReader(reader);

    List<String[]> readerList = null;
    try {
      readerList = read.readAll();
    } catch (IOException e) {
      System.out.println("CSV_Reader -> csvToArrayList() - readerList could not be read. " + e);
    }
    try {
      reader.close();
      read.close();
    } catch (IOException e) {
      System.out.println(
          "CSV_Reader -> csvToArrayList() - CSVReader/Reader could not be closed. " + e);
    }

    return readerList;
  }

  public static List<String[]> csvToStringArrayList(String path) {
    Reader pathReader = getPathReader(path);
    return readerToStringArrayList(pathReader);

  }

  public static String[][] csvTo2dArray(String path) {
    Reader pathReader = getPathReader(path);
    List<String[]> strings = readerToStringArrayList(pathReader);
    return arrayListTo2dArray(strings);
  }

  public static void adjustCsvStringList(List<String[]> data, String[][] doubleArray) {
    for (int i = 0; i < data.size(); i++) {
      String[] strings = replaceBracketsInside1dArray(data.get(i));
      for (int k = 0; k < strings.length; k++) {
        doubleArray[i][k] = strings[k];
      }
    }
  }

  public static Map<String, String> mapTwoCsvColumn(List<String[]> list, int columnA, int columnB) {
    Map<String, String> map = new HashMap<>();
    String[][] strings = arrayListTo2dArray(list);
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i][columnA], strings[i][columnB]);
    }
    return map;

  }

  private static String[] replaceBracketsInside1dArray(String[] array) {
    String s = Arrays.toString(array);
    return s.substring(1, s.length() - 1).split(";");
  }
}