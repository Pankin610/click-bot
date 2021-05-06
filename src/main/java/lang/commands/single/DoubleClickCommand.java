package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.gui.CodeItem;

import java.util.Scanner;

public class DoubleClickCommand extends AbstractSingleCommand {
  private static final String id = "DOUBLE_CLICK";
  public final static DoubleClickCommand DOUBLE_CLICK_COMMAND = new DoubleClickCommand();

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.doubleClick();
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    return DOUBLE_CLICK_COMMAND;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @Override
  public CodeItem getTreeRepresentation() {
    return new CodeItem(DOUBLE_CLICK_COMMAND);
  }
}
