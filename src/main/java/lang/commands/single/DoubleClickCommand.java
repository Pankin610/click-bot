package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.gui.CodeItem;

import java.util.Scanner;

public final class DoubleClickCommand extends AbstractSingleCommand {
  private final static String id = "DOUBLE_CLICK";
  public final static MouseLeftClick DOUBLE_CLICK_COMMAND = new MouseLeftClick();

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.doubleClick();
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    return DOUBLE_CLICK_COMMAND;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public CodeItem getTreeRepresentation() {
    return new CodeItem(DOUBLE_CLICK_COMMAND);
  }
}
