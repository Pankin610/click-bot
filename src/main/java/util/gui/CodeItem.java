package util.gui;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import lang.commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing 'CodeFragment' version of JavaFX's TreeItem.
 * It has some handful additional functionalities.
 */

public class CodeItem extends TreeItem<String> {
  private final Command command;

  public CodeItem(Command command) {
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

  public static void addAfter(TreeItem<String> me, CodeItem item) {
    TreeItem<String> parent = me.getParent();
    if (parent == null) return;
    ObservableList<TreeItem<String>> list = parent.getChildren();
    int ind = list.indexOf(me);
    List<TreeItem<String>> new_list = new ArrayList<>(list.subList(0, ind + 1));
    new_list.add(item);
    new_list.addAll(list.subList(ind + 1, list.size()));
    list.clear();
    list.addAll(new_list);
  }

  public static void appendToMe(TreeItem<String> me, CodeItem item) {
    me.getChildren().add(item);
  }
}
