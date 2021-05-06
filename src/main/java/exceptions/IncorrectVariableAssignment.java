package exceptions;

import lang.variables.Variable;

public class IncorrectVariableAssignment extends RuntimeException {
  private final Variable var;
  private final Object value;

  public IncorrectVariableAssignment(Variable m_var, Object m_value) {
    super(m_var.getName() + " cannot be assigned to " + m_value);
    var = m_var;
    value = m_value;
  }

  public Variable getVariable() {
    return var;
  }

  public Object getValue() {
    return value;
  }
}
