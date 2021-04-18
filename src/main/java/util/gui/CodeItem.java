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
        setValue(command.getId());
    }

    public Command getCommand() {
        return command;
    }
}
