package lang.commands;

import environments.Environment;
import exceptions.ExecException;

/**
 * Interface representing every class, which can be executed in some Environment.
 */

public interface Executable {
    /**
     * Execution method should be implemented as calls to Environment's methods.
     * @param envi Environment in which command should be executed.
     * @throws ExecException when something gone wrong during execution.
     */
    void execute(Environment envi) throws ExecException;
}
