package program;

import environments.Environment;
import lang.commands.Command;
import lang.commands.Executable;

public abstract class AbstractProgram implements Executable {
    Command[] commands;
    public void exec(Environment envi){}
    abstract public void loadFromFile(Object File);
    abstract public void saveToFile(Object File);
}
