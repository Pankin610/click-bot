package lang.single;

import environments.DesktopEnvironment;
import environments.Environment;
import lang.commands.single.DragCommand;
import org.junit.Test;
import program.ProgramDescription;
import util.Coordinate;
import util.builders.ProgramBuilder;

public class DragTest {
  @Test
  public void simpleDrag() {
    ProgramBuilder builder = new ProgramBuilder();
    builder.addCommand(new DragCommand(new Coordinate(500, 500))); // TODO wtf?
    Environment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();
  }
}
