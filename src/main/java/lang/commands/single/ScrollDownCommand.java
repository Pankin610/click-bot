package lang.commands.single;

import java.util.Scanner;

public final class ScrollDownCommand extends ScrollCommand {
  private static final String id = "SCROLL_DOWN";

  public ScrollDownCommand(int count) {
    super(count);
  }

  @Override
  public String getStringRepresentation() {
    return id + ' ' + where;
  }

  @Override
  public String getId() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public ScrollDownCommand parseFromString(Scanner scanner) {
    return new ScrollDownCommand(Integer.parseInt(scanner.next()));
  }

  @Override
  public String getPattern() {
    return id + " number";
  }
}
