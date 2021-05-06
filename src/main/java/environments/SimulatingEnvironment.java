package environments;

import program.Program;

/**
 * This environment is supposed to handle simulations (simulating Program in controlled way,
 * for example, waiting for user action before executing next command)
 */
public final class SimulatingEnvironment extends AbstractEnvironment {
  protected SimulatingEnvironment(Program program) {
    super(program);
  }
}
