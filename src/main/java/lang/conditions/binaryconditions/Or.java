package lang.conditions.binaryconditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.CodeFactory;
import lang.conditions.Condition;

import java.util.Scanner;

public final class Or extends BinaryCondition {
  private static final String id = "OR";

  public Or(Condition condition1, Condition condition2) {
    super(condition1, condition2);
  }

  @Override
  public boolean eval(Environment envi) throws EvaluationException {
    return condition1.eval(envi) || condition2.eval(envi);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Condition parseFromString(Scanner scanner) {
    Condition con1 = CodeFactory.parseCondition(scanner);
    Condition con2 = CodeFactory.parseCondition(scanner);
    return new Or(con1, con2);
  }
}
