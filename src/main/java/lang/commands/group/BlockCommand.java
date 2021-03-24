package lang.commands.group;

import lang.commands.AbstractCommand;
import lang.commands.Command;
import util.builders.BlockBuilder;

/**
 * Abstract class used when command should contains group of commands as its field.
 * Blocks of commands are some kind of exception - they can be fully implemented without invoking environment methods.
 */
public abstract class BlockCommand extends AbstractCommand {
    protected final Command[] commands;
    protected BlockCommand(Command[] m_commands){
        commands = new Command[m_commands.length];
        System.arraycopy(m_commands, 0, commands, 0, m_commands.length);
    }
    protected BlockCommand(BlockBuilder m_commands){
        commands = m_commands.toArray();
    }
}
