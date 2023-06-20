package com.joyboys.common.xss;

import com.joyboys.common.utils.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义xss校验注解实现.
 *
 * @author joyboys
 */
public class XssValidator implements ConstraintValidator<Xss, String> {

  private static final String HTML_PATTERN = "<(\\S*?)[^>]*>.*?|<.*? />";

  public static boolean containsHtml(String value) {
    Pattern pattern = Pattern.compile(HTML_PATTERN);
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isBlank(value)) {
      return true;
    }
    return !containsHtml(value);
  }
}