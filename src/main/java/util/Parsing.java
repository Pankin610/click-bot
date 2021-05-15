package util;

import lang.variables.Variable;

public class Parsing {
  static public boolean validString(String s) {
    return s.indexOf('\'') == -1;
  }

  static public <T> String parseLiteral(T literal) {
    return literal.toString();
  }
  static public String parseLiteral(String literal) {
    if (!validString(literal)) {
      throw new IllegalArgumentException(literal);
    }
    return "'" + literal + "'";
  }
  static public String parseLiteral(Variable v) {
    return v.getName();
  }
}
