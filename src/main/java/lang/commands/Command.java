package lang.commands;

import environments.Environment;
import exceptions.NonImplementedMethodException;
import javafx.scene.control.TreeItem;
import lang.CodeFragment;
import lang.commands.single.AbstractSingleCommand;

import java.util.Scanner;

/**
 * Commands should be implemented as calls to Environment methods with corresponding parameters
 * in as generic style as possible.
 * toString method should describe how CodeFragment should be displayed in GUI.
 */
public interface Command extends Executable, CodeFragment {

  /**
   * This method should describe how Command should be showed as tree node inside project-creation window.
   *
   * @return TreeItem with representation.
   * For now, it may be non implemented.
   */
  default TreeItem<Command> getTreeRepresentation() {
    throw new NonImplementedMethodException("getTreeRepresentation");
  }

  /**
   * This method creates instance of CodeFragment based on TreeItem
   * @param item node with description of Command
   * @return instance of Command
   */
  default Command parseFromTree(TreeItem<Command> item) {
    throw new NonImplementedMethodException("parseFromTree");
  }

  /**
   * @return true when implements GroupCommand, false otherwise
   */
  boolean isGroup();

  String getPattern();

  /**
   * Static instance of Command interface representing "do nothing" command.
   */
  Command NOTHING = new AbstractSingleCommand() {
    @Override
    public void execute(Environment envi) {}

    @Override
    public String getStringRepresentation() {
      return getId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Command parseFromString(Scanner scanner) {
      return this;
    }

    @Override
    public String getId() {
      return "NOTHING";
    }
  };
}
