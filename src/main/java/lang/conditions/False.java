package lang.conditions;

import environments.Environment;

import java.util.Scanner;

public final class False extends AbstractCondition {
  private static final String id = "FALSE";
  public static final False FALSE = new False();

  @Override
  public boolean eval(Environment envi) {
    return false;
  }

  @Override
  public String getStringRepresentation() {
    return "FALSE";
  }

  @Override
  @SuppressWarnings("unchecked")
  public Condition parseFromString(Scanner scanner) {
    return FALSE;
  }

  @Override
  public String getId() {
    return id;
  }
}
