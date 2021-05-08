package lang.single;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.single.*;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

public class KeySequenceTests {
  @Test
  public void typeTest() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new TypeCommand("wassup"));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
  @Test
  public void copySomeText() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new HoldKeysCommand("CTRLc"));
    builder.addCommand(new ReleaseKeysCommand("CTRLc"));
    builder.addCommand(new MouseLeftClick());
    builder.addCommand(new HoldKeysCommand("CTRLv"));
    builder.addCommand(new ReleaseKeysCommand("CTRLv"));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
