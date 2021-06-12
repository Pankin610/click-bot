package lang.single;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.single.ExecuteCommand;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

public class ExecuteTest {
  @Test
  public void simpleTest() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new ExecuteCommand("mkdir lol"));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
