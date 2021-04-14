package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

public interface GroupCommand extends Command, Iterable<Command> {
    void executeBlock(Environment envi) throws ExecException;
}
