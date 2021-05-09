package lang.commands.single;

import javafx.scene.control.TreeItem;
import lang.CodeFragment;
import lang.commands.AbstractCommand;

/**
 * Abstract implementation of SingleCommand interface.
 */
public abstract class AbstractSingleCommand extends AbstractCommand implements SingleCommand {
  @Override
  public TreeItem<CodeFragment> getTreeRepresentation() {
    return new TreeItem<>(this);
  }
}
