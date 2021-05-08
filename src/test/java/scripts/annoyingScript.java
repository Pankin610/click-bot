package scripts;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.group.Repeat;
import lang.commands.single.TypeCommand;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

public class annoyingScript {
  @Test
  public void testing() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new Repeat(100, new TypeCommand("this is an annoying scriptENTER")));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
