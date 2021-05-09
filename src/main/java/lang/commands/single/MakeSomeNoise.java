package lang.commands.single;

import environments.Environment;
import lang.commands.Command;

import java.util.Scanner;

/**
 * Simple command which makes noise.
 */
public final class MakeSomeNoise extends AbstractSingleCommand {
  private static final String id = "MAKE_SOME_NOISE";
  public static final MakeSomeNoise MAKE_SOME_NOISE = new MakeSomeNoise();

  @Override
  public void execute(Environment envi) {
    envi.errorNoise();
  }

  @Override
  public String getStringRepresentation() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    return MAKE_SOME_NOISE;
  }

  @Override
  public String getId() {
    return id;
  }
}
