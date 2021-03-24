package lang.commands;

import environments.Environment;
import lang.CodeFragment;

import java.util.ListIterator;

/**
 * Commands should be implemented as calls to Environment methods with corresponding parameters
 * in as generic style as possible.
 */
public interface Command extends Executable, CodeFragment {
    /**
     * Static instance of Command interface representing "do nothing" command.
     */
    Command NOTHING = new Command() {
        @Override
        public void execute(Environment envi){}

        @Override
        public String getId() {
            return "NOTHING";
        }

        @Override
        public String getStringRepresentation() {
            return "NOTHING";
        }

        @Override
        public Command parseFromString(ListIterator<String> lines) {
            lines.next();
            return NOTHING;
        }
    };
}
