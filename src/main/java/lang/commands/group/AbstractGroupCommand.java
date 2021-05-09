package lang.commands.group;

import environments.Environment;
import javafx.scene.control.TreeItem;
import lang.CodeFragment;
import lang.commands.AbstractCommand;
import lang.commands.Command;
import util.builders.BlockBuilder;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Abstract implementation of GroupCommand interface.
 * Blocks of commands are some kind of exception - they can be fully implemented without invoking environment methods.
 */
public abstract class AbstractGroupCommand extends AbstractCommand implements GroupCommand {
  protected Command[] commands;

  protected AbstractGroupCommand(Command[] commands) {
    this.commands = new Command[commands.length];
    System.arraycopy(commands, 0, this.commands, 0, commands.length);
  }

  protected AbstractGroupCommand(BlockBuilder commands) {
    this(commands.toArray());
  }

  /**
   * Executes block of Commands inside {@link #commands commands} array.
   *
   * @param envi Environment where commands should be called.
   */
  @Override
  public void executeBlock(Environment envi) {
    for (Command command : commands) command.execute(envi);
  }

  /**
   * @return iterator for {@link #commands commands} array.
   */
  @Override
  public Iterator<Command> iterator() {
    return Arrays.stream(commands).iterator();
  }

  /**
   * Default implementation of getTreeRepresentation for GroupCommands.
   * Every Command inside {@link #commands commands} array is treated as a child node of the resulting TreeItem.
   *
   * @return TreeItem representation of {@code this}.
   */
  @Override
  public TreeItem<CodeFragment> getTreeRepresentation() {
    TreeItem<CodeFragment> res = new TreeItem<>(this);
    for (Command command : commands) res.getChildren().add(command.getTreeRepresentation());
    return res;
  }

  //TODO condition parsing
  @Override
  public CodeFragment parseFromTree(TreeItem<CodeFragment> item) {
    AbstractGroupCommand res = (AbstractGroupCommand) item.getValue();
    res.commands = new Command[item.getChildren().size()];
    int ind = 0;
    for(TreeItem<CodeFragment> child : item.getChildren()) {
      res.commands[ind++] = (Command) child.getValue().parseFromTree(child);
    }
    return res;
  }

  @Override
  public String toString() {
    return getId();
  }
}
