package lang.commands;

import javafx.scene.control.TreeItem;
import lang.AbstractCodeFragment;
import lang.CodeFragment;
import util.gui.CodeItem;

/**
 * Abstract implementation of Command interface.
 */

public abstract class AbstractCommand extends AbstractCodeFragment implements Command {
  /**
   * Default implementation of getTreeRepresentation method.
   *
   * @return CodeItem instance with ID of class.
   */
  @Override
  public TreeItem<CodeFragment> getTreeRepresentation() {
    return new TreeItem<>(this);
  }
}
