package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;

import java.util.Scanner;

public final class MouseLeftClick extends AbstractSingleCommand {
  private final static String id = "LEFT_CLICK";
  public final static MouseLeftClick MOUSE_LEFT_CLICK = new MouseLeftClick();

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.clickLeft();
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    return MOUSE_LEFT_CLICK;
  }

  @Override
  public String getId() {
    return id;
  }
}
