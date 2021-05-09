package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.gui.CodeItem;

import java.util.Scanner;

public final class MouseRightClick extends AbstractSingleCommand {
  private final static String id = "RIGHT_CLICK";
  public final static MouseRightClick MOUSE_RIGHT_CLICK = new MouseRightClick();

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.clickRight();
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    return MOUSE_RIGHT_CLICK;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public CodeItem getTreeRepresentation() {
    return new CodeItem(MOUSE_RIGHT_CLICK);
  }
}
