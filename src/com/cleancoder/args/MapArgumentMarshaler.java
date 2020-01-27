package com.cleancoder.args;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class MapArgumentMarshaler implements ArgumentMarshaler {
  private Map<String, String> map;

  public MapArgumentMarshaler(){
          map = new HashMap<>();
  }
  
  private void populateMap(String[] mapEntries) throws ArgsException {
	  for (String entry : mapEntries) {
        String[] entryComponents = entry.split(":");
        if (entryComponents.length != 2 || entryComponents[0].contentEquals(""))
          throw new ArgsException(MALFORMED_MAP);
        map.put(entryComponents[0], entryComponents[1]);
	  }
  }
  
  public void setValue(Iterator<String> currentArgument) throws ArgsException {
    try {
    	String[] mapEntries = currentArgument.next().split(",");
    	populateMap(mapEntries);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_MAP);
    }
  }

  public boolean validateValue(ArgumentMarshaler am) {
      return (am instanceof MapArgumentMarshaler);
      
  }
  
  public static Map<String, String> getValue(ArgumentMarshaler am) {
    if ((new MapArgumentMarshaler()).validateValue(am))
      return ((MapArgumentMarshaler) am).map;
    else
      return new HashMap<>();
  }
}
