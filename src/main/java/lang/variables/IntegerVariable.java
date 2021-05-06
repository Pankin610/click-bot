package lang.variables;

import exceptions.IncomparableVariablesException;
import exceptions.IncorrectVariableAssignment;

import java.util.Objects;
import java.util.Scanner;

public final class IntegerVariable extends AbstractVariable {
  private static final String id = "INT";
  private Integer val;

  public IntegerVariable(String name, Integer val) {
    super(name);
    this.val = val;
  }

  @Override
  public Integer getValue() {
    return val;
  }

  // regular java objects serve the role of literals
  @Override
  public void setValue(Object value) {
    if (value instanceof Integer) {
      val = (Integer) value;
    }
    if (value instanceof IntegerVariable) {
      val = ((IntegerVariable) value).getValue();
    }
    if (value instanceof StringVariable) {
      val = ((StringVariable) value).toInteger();
    }
    throw new IncorrectVariableAssignment(this, value);
  }

  public void changeValue(Integer v) {
    val = v;
  }

  public void add(Integer v) {
    val += v;
  }

  public void sub(Integer v) {
    val -= v;
  }

  public void increment() {
    val++;
  }

  public void decrement() {
    val--;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (o instanceof IntegerVariable) return val.equals(((IntegerVariable) o).val);
    if (o instanceof Integer) return val.equals(o);
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }

  @Override
  public String toString() {
    return getName() + ": " + val;
  }

  @Override
  @SuppressWarnings("unchecked")
  public IntegerVariable parseFromString(Scanner scanner) {
    return new IntegerVariable(scanner.next(), scanner.nextInt());
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public int compareTo(Variable other) {
    if (other instanceof IntegerVariable) {
      return this.getValue().compareTo(((IntegerVariable) other).getValue());
    }
    throw new IncomparableVariablesException(this.getName(), other.getName());
  }
}
