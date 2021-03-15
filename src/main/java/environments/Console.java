package environments;

import program.Program;

/**
 * Class describing how program should behave in console environment.
 * Methods associated with commands should be implemented in superclass.
 */

public class Console extends AbstractEnvironment {
    @Override
    public void runProgram(Program prog) {
        prog.exec(this);
    }
}
