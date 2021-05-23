package util;

import javafx.beans.binding.ObjectExpression;
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
    if (o instanceof Variable var) {
      return parseLiteral(var);
    }
    if (o instanceof String str) {
      return parseLiteral(str);
    }
    return o.toString();
  }
}
