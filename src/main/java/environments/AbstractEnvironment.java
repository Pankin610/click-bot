package environments;

import program.Program;
import util.Pair;

/**
 * Abstract environment contains default (Console) implementation of methods associated with instances of Command interface,
 * such as PushButton, Move, Hold, etc...
 */

public abstract class AbstractEnvironment implements Environment {
    public void runProgram(Program prog){
        prog.exec(this);
    }
    public void pushKey(char z){}
    public void moveMouse(Pair cords){}
    public void wait(int tim){}
}
