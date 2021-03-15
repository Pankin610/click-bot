package environments;

import program.Program;
import util.Pair;

/**
 * This interface describes methods which implementation is necessary to make command calls correct.
 */

public interface Environment {
    void runProgram(Program prog);
    void pushKey(char z);
    void moveMouse(Pair cords);
    void wait(int tim);
    /* To be continued... */
}
