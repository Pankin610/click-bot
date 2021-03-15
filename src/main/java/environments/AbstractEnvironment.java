package environments;

import util.Pair;

/**
 * Abstract environment contains default (Console) implementation of methods associated with instances of Command interface,
 * such as PushButton, Move, Hold, etc...
 */

public abstract class AbstractEnvironment implements Environment {
    public void runProgram(){}
    public void pushKey(char z){}
    public void moveMouse(Pair cords){}
    public void wait(int tim){}
}
