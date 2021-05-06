package lang.conditions;

import environments.Environment;

import java.util.Scanner;

public final class True implements Condition {
  private static final String id = "TRUE";
  public static final True TRUE = new True();

  @Override
  public boolean eval(Environment envi) {
    return true;
  }

  @Override
  public String getStringRepresentation() {
    return "TRUE";
  }

  @Override
  @SuppressWarnings("unchecked")
  public Condition parseFromString(Scanner scanner) {
    return TRUE;
  }

  @Override
  public String getId() {
    return id;
  }
}
