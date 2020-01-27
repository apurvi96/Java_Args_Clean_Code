package com.cleancoder.args;

import java.util.*;
import java.util.Optional;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class Args {
  private Map<Character, ArgumentMarshaler> marshalers;
  private ListIterator<String> currentArgument;

  public Args(){
    marshalers = new HashMap<>();
  }
  public Args(
		  String schema, 
		  String[] args) throws ArgsException {
    marshalers = new HashMap<>();
    parseSchema(schema);
    parseArgumentStrings(Arrays.asList(args));
  }

  private void parseSchema(String schema) throws ArgsException {
    for (String element : schema.split(","))
      if (element.length() > 0)
        parseSchemaElement(element.trim());
  }

  private void populateMarshelersMap(
		  String elementTail, 
		  char elementId) throws ArgsException{
  if (elementTail.length() == 0)
      marshalers.put(elementId, new BooleanArgumentMarshaler());
  else if (elementTail.equals("*"))
      marshalers.put(elementId, new StringArgumentMarshaler());
  else if (elementTail.equals("#"))
      marshalers.put(elementId, new IntegerArgumentMarshaler());
  else if (elementTail.equals("##"))
      marshalers.put(elementId, new DoubleArgumentMarshaler());
  else if (elementTail.equals("[*]"))
      marshalers.put(elementId, new StringArrayArgumentMarshaler());
  else if (elementTail.equals("&"))
      marshalers.put(elementId, new MapArgumentMarshaler());
  else
      throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId);

  }
  private void parseSchemaElement(String element) throws ArgsException {
    char elementId = element.charAt(0);
    String elementTail = element.substring(1);
    validateSchemaElementId(elementId);
    populateMarshelersMap(elementTail,elementId);
  }

  private void validateSchemaElementId(char elementId) throws ArgsException {
    if (!Character.isLetter(elementId))
      throw new ArgsException(INVALID_ARGUMENT_NAME, elementId);
  }

  private void parseArgumentStrings(List<String> argsList) throws ArgsException {
    for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
      String argString = currentArgument.next();
      if (argString.startsWith("-")) {
        parseArgumentCharacter(argString.substring(1));
      } else {
        throw new ArgsException(INVALID_ARGUMENT_FORMAT, argString);
      }
    }
  }
  private void getArgValue(
		  char argSymbol,
		  ArgumentMarshaler marshalerType) throws ArgsException{
    try {
        marshalerType.setValue(currentArgument);
      } catch (ArgsException e) {
        e.setErrorArgumentId(argSymbol);
        throw e;
      }
  }
  private void validateParseArgument(String validArg) throws ArgsException {
  	if(validArg.length() != 1)
    	throw new ArgsException(INVALID_ARGUMENT_FORMAT, validArg);
  }

  
  private void parseArgumentCharacter(String argChar) throws ArgsException {
  	validateParseArgument(argChar);
  	char argSymbol=argChar.charAt(0);
    ArgumentMarshaler marshalerType = marshalers.get(argSymbol);
    Optional<ArgumentMarshaler> optionalObjectOfMarshalerType = Optional.ofNullable(marshalerType);
    if (!optionalObjectOfMarshalerType.isPresent()) {
      throw new ArgsException(UNEXPECTED_ARGUMENT, argSymbol);
    } else {
       getArgValue(argSymbol, marshalerType);
    }
  }

  public int nextArgument() {
	    return currentArgument.nextIndex();
  }

  public boolean getBoolean(char arg) {
    return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public String getString(char arg) {
    return StringArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public int getInt(char arg) {
    return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
  }
  public double getDouble(char arg) {
    return DoubleArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public String[] getStringArray(char arg) {
    return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public Map<String, String> getMap(char arg) {
    return MapArgumentMarshaler.getValue(marshalers.get(arg));
  }
}