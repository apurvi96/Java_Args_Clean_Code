package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
  private int intValue;
  private  String parameter;
  public IntegerArgumentMarshaler(){
    intValue = 0;
    parameter = "";
  }
  public void setValue(Iterator<String> currentArgument) throws ArgsException {
   
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_INTEGER);
    } catch (NumberFormatException e) {
      throw new ArgsException(INVALID_INTEGER, parameter);
    }
  }

  public boolean validateValue(ArgumentMarshaler am) {
      return (am instanceof IntegerArgumentMarshaler);
  }

  public static int getValue(ArgumentMarshaler am) {
    if ((new IntegerArgumentMarshaler()).validateValue(am))
      return ((IntegerArgumentMarshaler) am).intValue;
    else
      return 0;
  }
}
