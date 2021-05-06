package lang.commands.single;

import environments.Environment;
import lang.commands.Command;
import util.Key;

import java.util.Collection;
import java.util.Scanner;

public final class ReleaseKeysCommand extends KeySequenceCommand {
  private static final String id = "HOLD";

  public ReleaseKeysCommand(Collection<Key> key_sequence) {
    super(key_sequence);
  }

  public ReleaseKeysCommand(String code) {
    super(code);
  }

  @Override
  public void execute(Environment envi) {
    for (Key key : key_sequence) {
      envi.releaseKey(key.integer_code);
    }
  }

  @Override
  public String getId() {
    return id;
  }

  // basic parsing
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    return new ReleaseKeysCommand(scanner.nextLine());
  }
}
