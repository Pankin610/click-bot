package lang.variables;

import exceptions.NonImplementedMethodException;
import lang.AbstractCodeFragment;
import util.Parsing;

public abstract class AbstractVariable extends AbstractCodeFragment implements Variable {
  private final String name;

  static public boolean validName(String name) {
    return name.length() > 0 &&
            !Character.isDigit(name.charAt(0)) &&
            Parsing.validString(name);
  }

  protected AbstractVariable(String name) {
    if (!validName(name)) {
      throw new IllegalArgumentException("Illegal variable name.");
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Object getValue() {
    throw new NonImplementedMethodException("getValue");
  }

  @Override
  public int compareTo(Variable o) {
    throw new NonImplementedMethodException("compareTo");
  }

  /**
   * Every Variable should use this pattern for parsing.
   *
   * @return String representation of Variable.
   */
  @Override
  final public String getStringRepresentation() {
    return getId() + ' ' + getName() + ' ' + getValue();
  }

  @Override
  public String toString() {
    return getName() + ": " + getValue();
  }
}
