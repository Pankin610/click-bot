package lang.commands.group;

import lang.commands.AbstractCommand;
import lang.commands.Command;
import util.BlockOfCommands;
import util.builders.BlockBuilder;

/**
 * Abstract class used when command should contains group of commands as its field.
 * Blocks of commands are some kind of exception - they can be fully implemented without invoking environment methods.
 */
public abstract class GroupCommand extends AbstractCommand {
    protected final BlockOfCommands commands;
    protected GroupCommand(Command[] commands){
        this.commands = new BlockOfCommands(commands);
    }
    protected GroupCommand(BlockBuilder commands){
        this(commands.toArray());
    }
}
