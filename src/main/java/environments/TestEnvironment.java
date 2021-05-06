package environments;

import program.Program;

import java.util.LinkedList;

/**
 * Environment used for testing purposes. Every command should change state of Environment,
 * by manipulating its fields.
 */

public final class TestEnvironment extends AbstractEnvironment {
  public TestEnvironment(Program program) {
    super(program);
  }

  /**
   * State field.
   */
  public String returns;

  /**
   * executionList should contain information about every executed Command, evaluated Condition etc.
   */
  public LinkedList<String> executionList;
}
