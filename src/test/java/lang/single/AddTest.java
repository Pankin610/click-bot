package lang.single;

import environments.DesktopEnvironment;
import exceptions.ExecException;
import lang.commands.var_manipulation.AddCommand;
import lang.variables.IntegerVariable;
import lang.variables.StringVariable;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import org.junit.Test;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

import static org.junit.Assert.fail;

public class AddTest {
  @Test
  public void basic() {
    ProgramBuilder builder = new ProgramBuilder();
    Variable var = new IntegerVariable("test", 0);
    builder.addCommand(new AddCommand("test", 5));
    builder.addVariable(new VariableDescription(var));
    DesktopEnvironment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();

    System.out.println(envi.getVarByName("test").getValue());
  }

  @Test
  public void basicString() {
    ProgramBuilder builder = new ProgramBuilder();
    Variable var = new StringVariable("test", "0");
    builder.addCommand(new AddCommand("test", 5));
    builder.addVariable(new VariableDescription(var));
    DesktopEnvironment envi = new DesktopEnvironment(new ProgramDescription(builder));
    envi.runProgram();

    System.out.println(envi.getVarByName("test").getValue());
  }
}
