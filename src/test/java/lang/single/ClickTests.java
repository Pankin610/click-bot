package lang.single;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.single.DoubleClickCommand;
import lang.commands.single.MouseLeftClick;
import lang.commands.single.MouseRightClick;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

public class ClickTests {
  @Test
  public void leftClickTest() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(MouseLeftClick.MOUSE_LEFT_CLICK);
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
  @Test
  public void rightClickTest() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(MouseRightClick.MOUSE_RIGHT_CLICK);
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
  @Test
  public void doubleClickTest() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new DoubleClickCommand());
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
