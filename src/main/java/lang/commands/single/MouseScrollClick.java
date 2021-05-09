package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.gui.CodeItem;

import java.util.Scanner;

public class MouseScrollClick extends AbstractSingleCommand {
  private final static String id = "SCROLL_CLICK";
  public final static MouseScrollClick MOUSE_SCROLL_CLICK = new MouseScrollClick();

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.clickScroll();
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    return MOUSE_SCROLL_CLICK;
  }

  @Override
  public String getId() {
    return id;
  }
}
