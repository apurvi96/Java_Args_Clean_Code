package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
	private double doubleValue;
	private String parameter;
	public DoubleArgumentMarshaler(){
		doubleValue = 0;
		parameter = "";
	}
	public void setValue(Iterator<String> currentArgument) throws ArgsException {
		try {
			parameter = currentArgument.next();
			doubleValue = Double.parseDouble(parameter);
		} catch (NoSuchElementException e) {
			throw new ArgsException(MISSING_DOUBLE);
		} catch (NumberFormatException e) {
			throw new ArgsException(INVALID_DOUBLE, parameter);
		}
	}
	public boolean validateValue(ArgumentMarshaler am) {
		return (am instanceof DoubleArgumentMarshaler);
	}
	public static double getValue(ArgumentMarshaler am) {
		if ((new DoubleArgumentMarshaler()).validateValue(am))
			return ((DoubleArgumentMarshaler) am).doubleValue;
		else
			return 0.0;
	}
}
