package lang.conditions.binaryrelations;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.NoVariableWithThisNameException;
import lang.conditions.Condition;

import java.util.Scanner;

public final class Equal extends BinaryRelation {
  private static final String id = "EQUAL";

  public Equal(String variable1, String variable2) {
    super(variable1, variable2);
  }

  @Override
  public boolean eval(Environment envi) throws EvaluationException {
    try {
      return envi.getVarByName(variable1).getValue().equals(envi.getVarByName(variable2).getValue());
    } catch (NoVariableWithThisNameException e) {
      throw new EvaluationException("Variable with name: " + e.getName() + " not found (Equal)");
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
    return new Equal(name1, name2);
  }
}
