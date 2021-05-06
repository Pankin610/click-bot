package lang.conditions.binaryrelations;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.IncomparableVariablesException;
import exceptions.NoVariableWithThisNameException;
import lang.conditions.Condition;

import java.util.Scanner;

public final class Less extends BinaryRelation {
  private static final String id = "LESS";

  public Less(String m_variable1, String m_variable2) {
    super(m_variable1, m_variable2);
  }

  @Override
  public boolean eval(Environment envi) throws EvaluationException {
    try {
      return envi.getVarByName(variable1).compareTo(envi.getVarByName(variable2)) < 0;
    } catch (NoVariableWithThisNameException e) {
      throw new EvaluationException("No variable with name: " + e.getName() + " (Less)");
    } catch (IncomparableVariablesException ex) {
      throw new EvaluationException("Incomparable variables (Less)");
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Condition parseFromString(Scanner scanner) {
    String name1 = scanner.next();
    String name2 = scanner.next();
    return new Less(name1, name2);
  }
}
