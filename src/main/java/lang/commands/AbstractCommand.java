package lang.commands;

import lang.AbstractCodeFragment;
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
  public CodeItem getTreeRepresentation() {
    return new CodeItem(this);
  }
}
