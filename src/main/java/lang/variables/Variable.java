package lang.variables;

import lang.CodeFragment;

public interface Variable extends CodeFragment, Comparable<Variable> {
  Object getValue();

  default String getStringValue() {
    return getValue().toString();
  }

  String getName();

  void setValue(Object value);
}
