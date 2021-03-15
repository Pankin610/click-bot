package lang.commands;

/**
 * Abstract class used when command should contains group of commands as its field.
 * Blocks of commands are some kind of exception - they can be fully implemented without invoking environment methods.
 */
public abstract class BlockCommand extends AbstractCommand {
    protected Command[] coms;
}
