package com.cleancoder.args;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
  private boolean booleanValue;
  public BooleanArgumentMarshaler(){
    booleanValue = false;
  }
  public void setValue(Iterator<String> currentArgument) throws ArgsException {
    booleanValue = true;
  }
  public boolean validateValue(ArgumentMarshaler am) {
      return (am instanceof BooleanArgumentMarshaler);
        
  }
  public static boolean getValue(ArgumentMarshaler am) {
    if ((new BooleanArgumentMarshaler()).validateValue(am))
      return ((BooleanArgumentMarshaler) am).booleanValue;
    else
      return false;
  }
}
