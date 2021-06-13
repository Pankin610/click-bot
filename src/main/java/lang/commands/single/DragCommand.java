package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.Coordinate;

import java.util.Scanner;

public class DragCommand extends AbstractSingleCommand {
  private static final String id = "DRAG";
  private final Coordinate where;

  public DragCommand(Coordinate where) {
    this.where = where;
  }

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.drag(where);
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    return new DragCommand(new Coordinate(scanner.nextInt(), scanner.nextInt()));
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getStringRepresentation() {
    return id + ' ' + where.x + ' ' + where.y;
  }

  @Override
  public String getPattern() {
    return "DRAG x_cord y_cord";
  }
}
