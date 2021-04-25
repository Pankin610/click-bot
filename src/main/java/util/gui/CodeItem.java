package util.gui;

import javafx.scene.control.TreeItem;
import lang.commands.Command;

/**
 * Class representing 'CodeFragment' version of JavaFX's TreeItem.
 * It has some handful additional functionalities.
 */

public class CodeItem extends TreeItem<String> {
    private final Command command;

    public CodeItem(Command command){
        this.command = command;
        setValue(command.getId()); /* default value - of course it may be changed is getTreeRepresentation method */
    }

    public Command getCommand() {
        return command;
    }

    /**
     * @return String representation of Command via
     * {@link lang.CodeFragment#getStringRepresentation() getStringRepresentation()}.
     */
    @Override
    public String toString() {
        return command.getStringRepresentation();
    }
}
