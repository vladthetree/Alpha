package Toolbox.csvMethodes;

import static Toolbox.arrayConverter.ArrayList.arrayListTo2dArray;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Datacolumn {


  public static String[] getSingleCSVDataColumns(List<String[]> arrayList, int columnNumber) {
    if (columnNumber < 0) {
      throw new ArithmeticException("getSingleCSVDataColumns : columnNumber is smaller then 0");
    }
    String[][] listTo2dArray = arrayListTo2dArray(arrayList);
    String[] column = new String[listTo2dArray.length];

    for (int rowCounter = 0; rowCounter < listTo2dArray.length; rowCounter++) {
      column[rowCounter] = listTo2dArray[rowCounter][columnNumber - 1];
    }
    return column;
  }

  public static List getSingleCSVRow(List<String[]> arrayList, int rowNumber) {
    if (rowNumber < 0 || rowNumber > arrayList.size()) {
      throw new ArithmeticException(
          "getSingleCSVRow : rowNumber is smaller then 0 or bigger then " + arrayList.size());
    }
    String[][] listTo2dArray = arrayListTo2dArray(arrayList);
    return Arrays
        .stream(listTo2dArray[rowNumber - 1])
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }


}
