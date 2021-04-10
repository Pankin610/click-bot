package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.AbstractCommand;
import lang.commands.Command;
import util.builders.BlockBuilder;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Abstract class used when command should contains group of commands as its field.
 * Blocks of commands are some kind of exception - they can be fully implemented without invoking environment methods.
 */
public abstract class AbstractGroupCommand extends AbstractCommand implements GroupCommand {
    protected final Command[] commands;
    protected AbstractGroupCommand(Command[] commands){
        this.commands = new Command[commands.length];
        System.arraycopy(commands, 0, this.commands, 0, commands.length);
    }
    protected AbstractGroupCommand(BlockBuilder commands){
        this(commands.toArray());
    }
    protected void executeBlock(Environment envi) throws ExecException {
        for(Command command : commands) command.execute(envi);
    }

    @Override
    public Iterator<Command> iterator() {
        return Arrays.stream(commands).iterator();
    }
}
