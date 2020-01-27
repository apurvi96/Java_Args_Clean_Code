package com.cleancoder.args;

import java.util.Iterator;

public interface ArgumentMarshaler {
  void setValue(Iterator<String> currentArgument) throws ArgsException;
  boolean validateValue(ArgumentMarshaler am);
}
