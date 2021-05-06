package lang.variables;

import lang.AbstractCodeFragment;
import lang.CodeFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * This class represents initial state of variable. Should be used only as field in Program class,
 * it is not valid CodeFragment. It mimics behaviour of normal Variable.
 */

public final class VariableDescription extends AbstractCodeFragment {
  private final String description;
  private final String id;
  private final String name;

  public VariableDescription(Variable var) {
    description = var.getStringRepresentation();
    id = var.getId();
    name = var.getName();
  }

  /**
   * To use this constructor, description must match getStringRepresentation.
   *
   * @param description of Variable.
   */
  public VariableDescription(String description) {
    this(CodeFactory.parseVariable(description));
  }

  @Override
  public String getStringRepresentation() {
    return description;
  }

  @Override
  @SuppressWarnings("unchecked")
  public VariableDescription parseFromString(Scanner scanner) {
    return new VariableDescription(CodeFactory.parseVariable(scanner));
  }

  @Override
  public String getId() {
    return id;
  }

  /**
   * @return Variable instance based on description.
   */
  public Variable getVariable() {
    InputStream is = new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8));
    Scanner scanner = new Scanner(is);
    return CodeFactory.parseVariable(scanner);
  }

  public String getName() {
    return name;
  }
}
