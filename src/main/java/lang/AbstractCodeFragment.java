package lang;

import exceptions.NonImplementedMethodException;

import java.util.Scanner;

public abstract class AbstractCodeFragment implements CodeFragment {
  @Override
  public String getStringRepresentation() {
    throw new NonImplementedMethodException("getStringRepresentation");
  }

  @Override
  public <T extends CodeFragment> T parseFromString(Scanner scanner) {
    throw new NonImplementedMethodException("parseFromString");
  }

  @Override
  public String getId() {
    throw new NonImplementedMethodException("getId");
  }
}
