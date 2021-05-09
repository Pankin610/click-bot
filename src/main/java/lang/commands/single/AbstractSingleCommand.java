package lang.commands.single;

import javafx.scene.control.TreeItem;
import lang.CodeFragment;
import lang.commands.AbstractCommand;
import lang.commands.Command;

/**
 * Abstract implementation of SingleCommand interface.
 */
public abstract class AbstractSingleCommand extends AbstractCommand implements SingleCommand {
  @Override
  public TreeItem<Command> getTreeRepresentation() {
    return new TreeItem<>(this);
  }

  @Override
  public Command parseFromTree(TreeItem<Command> item) {
    return item.getValue();
  }

  @Override
  public String toString() {
    return getStringRepresentation();
  }
}
