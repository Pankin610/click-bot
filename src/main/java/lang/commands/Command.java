package lang.commands;

import environments.Environment;
import javafx.scene.control.TreeItem;
import lang.CodeFragment;
import lang.commands.single.AbstractSingleCommand;

import java.util.Scanner;

/**
 * Commands should be implemented as calls to Environment methods with corresponding parameters
 * in as generic style as possible.
 */
public interface Command extends Executable, CodeFragment {

  /**
   * Static instance of Command interface representing "do nothing" command.
   */
  Command NOTHING = new AbstractSingleCommand() {
    @Override
    public void execute(Environment envi) {
    }

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
