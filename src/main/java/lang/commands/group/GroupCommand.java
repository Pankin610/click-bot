package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

/**
 * Interface representing Commands which call block of other commands.
 */
public interface GroupCommand extends Command, Iterable<Command> {
  void executeBlock(Environment envi) throws ExecException;
}
