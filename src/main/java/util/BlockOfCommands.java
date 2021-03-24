package util;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import lang.commands.Executable;
import util.builders.BlockBuilder;

/**
 * Class used as field in extensions of GroupCommand abstract class.
 */

public final class BlockOfCommands implements Executable {
    private final Command[] commands;
    public BlockOfCommands(Command[] commands){
        this.commands = new Command[commands.length];
        System.arraycopy(commands, 0, this.commands, 0, commands.length);
    }
    public BlockOfCommands(BlockBuilder commands){
        this(commands.toArray());
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        for(Command command : commands) command.execute(envi);
    }
}
