package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
  private List<String> strings;
  public StringArrayArgumentMarshaler(){
    strings = new ArrayList<>();
  }
  
  public void setValue(Iterator<String> currentArgument) throws ArgsException {
    try {
      strings.add(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public boolean validateValue(ArgumentMarshaler am) {
      return (am instanceof StringArrayArgumentMarshaler);
       
  }

  public static String[] getValue(ArgumentMarshaler am) {
    if ((new StringArrayArgumentMarshaler()).validateValue(am))
      return ((StringArrayArgumentMarshaler) am).strings.toArray(new String[0]);
    else
      return new String[0];
  }
}
