package lang.commands;

import environments.Environment;
import exceptions.NonImplementedMethodException;
import lang.CodeFragment;
import lang.commands.single.AbstractSingleCommand;
import util.gui.CodeItem;

import java.util.Scanner;

/**
 * Commands should be implemented as calls to Environment methods with corresponding parameters
 * in as generic style as possible.
 */
public interface Command extends Executable, CodeFragment {

    /**
     * This method should describe how Command should be showed as tree node inside project-creation window.
     * @return TreeItem with representation.
     * For now, it may be non implemented.
     */
    default CodeItem getTreeRepresentation() {
        throw new NonImplementedMethodException("getTreeRepresentation");
    }

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

        @Override
        public CodeItem getTreeRepresentation() {
            return new CodeItem(this);
        }
    };
}
