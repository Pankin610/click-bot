package util;

import lang.variables.Variable;

public class Parsing {
  static public boolean validString(String s) {
    return s.indexOf('\'') == -1;
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
  static public String parseLiteral(Object o) {
    if (o instanceof Variable) {
      return parseLiteral((Variable) o);
    }
    if (o instanceof String) {
      return parseLiteral((String) o);
    }
    return o.toString();
  }
}
