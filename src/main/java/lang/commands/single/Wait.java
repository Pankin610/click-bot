package lang.commands.single;

import environments.Environment;
import lang.commands.Command;

import java.util.Scanner;

public final class Wait extends AbstractSingleCommand {
  private static final String id = "WAIT";
  private final int wait_time;

  public Wait(int wait_time_milliseconds) {
    wait_time = wait_time_milliseconds;
  }

  @Override
  public void execute(Environment envi) {
    envi.wait(wait_time);
  }

  @Override
  public String getStringRepresentation() {
    return getId() + ' ' + wait_time;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    return new Wait(scanner.nextInt());
  }

  @Override
  public String getId() {
    return id;
  }
}
