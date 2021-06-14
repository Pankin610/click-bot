package lang.commands.single;

import java.util.Scanner;

public final class ScrollUpCommand extends ScrollCommand {
  private static final String id = "SCROLL_UP";

  public ScrollUpCommand(int count) {
    super(-count);
  }

  @Override
  public String getStringRepresentation() {
    return id + ' ' + (-where);
  }

  @Override
  public String getId() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public ScrollUpCommand parseFromString(Scanner scanner) {
    return new ScrollUpCommand(Integer.parseInt(scanner.next()));
  }

  @Override
  public String getPattern() {
    return id + " number";
  }
}
