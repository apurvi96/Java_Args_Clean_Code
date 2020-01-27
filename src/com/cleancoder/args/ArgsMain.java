package com.cleancoder.args;
import java.util.Map;
public class ArgsMain {
  public static void main(String[] input) {
    try {
      Args arg = new Args("f,s*,n#,a##,p[*],m&", input);
      executeApplication(arg);
    } catch (ArgsException e) {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }
  private static void displayLoggingDetails(String[] loggingDetails)
  {
    if(loggingDetails.length == 0)
      System.out.printf("");
    else {
      System.out.printf("logging Details: ");
      for(int i = 0; i < loggingDetails.length; i++) {
        System.out.printf("%s ", loggingDetails[i]);
      }
    }
   }

  private static void displaymapDetails(Map<String,String> mapDetails)
  {
    if(mapDetails.size() == 0)
      System.out.printf("");
    else {
      System.out.printf("Map Details: ");
      mapDetails.forEach((k,v) -> System.out.printf( "{ %s,%s }", k, v)); 
       System.out.printf("\n");
    }
  }
  private static void executeApplication(Args parseData) {
    boolean logging = parseData.getBoolean('f');
    int port = parseData.getInt('n');
    String directory = parseData.getString('s');
    double accuracy = parseData.getDouble('a');
    String[] loggingDetails = parseData.getStringArray('p');
    Map<String,String> mapDetails = parseData.getMap('m');
    System.out.printf("logging is %s, port:%d, directory:%s, accuracy:%f ",logging, port, directory, accuracy);
    displayLoggingDetails(loggingDetails);
    displaymapDetails(mapDetails);     
  }
}