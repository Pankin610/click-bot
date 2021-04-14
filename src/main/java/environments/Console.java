package environments;

import program.Program;
import util.Coordinate;

/**
 * Class describing how program should behave in console environment.
 * Most methods associated with commands should be implemented in superclass.
 */

public final class Console extends AbstractEnvironment {
    public Console(Program program) {
        super(program);
    }
}
