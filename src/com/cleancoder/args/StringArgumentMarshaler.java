package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler {
  private String stringValue;
  public StringArgumentMarshaler() {
    stringValue = "";
  }
  
  public void setValue(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public boolean validateValue(ArgumentMarshaler am) {
      return (am instanceof StringArgumentMarshaler);
  }
  
  public static String getValue(ArgumentMarshaler am) {
    if((new StringArgumentMarshaler()).validateValue(am))
      return ((StringArgumentMarshaler) am).stringValue;
    else
      return "";
  }
}
