package com.joyboys.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToDateConverter extends SimpleArgumentConverter {

  @Override
  protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
    if (source == null) {
      return null;
    }
    if (source instanceof String && targetType.equals(Date.class)) {
      try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);  // Make the parser non-lenient
        return format.parse((String) source);
      } catch (ParseException e) {
        // Log the error if necessary
        // System.err.println("Failed to convert string to date: " + e);
        return null;  // Return null if the date is invalid
      }
    } else {
      throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
          + targetType + " not supported.");
    }
  }
}


