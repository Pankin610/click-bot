package lang.single;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.Command;
import lang.commands.single.ScrollCommand;
import lang.commands.single.ScrollDownCommand;
import lang.commands.single.ScrollUpCommand;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

import static org.junit.Assert.fail;

public class ScrollTests {
  @Test
  public void scrollUpTest() {
    try {
      Command invalid = new ScrollUpCommand(-5);
      fail("No exception.");
    }
    catch (IllegalArgumentException e) {
      System.out.println("Good job");
    }

    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new ScrollUpCommand(5));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
  @Test
  public void scrollDownTest() {
    try {
      Command invalid = new ScrollDownCommand(-5);
      fail("No exception.");
    }
    catch (IllegalArgumentException e) {
      System.out.println("Good job");
    }

    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new ScrollDownCommand(5));
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
