package lang.commands.single;

import environments.DesktopEnvironment;
import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

import java.util.Scanner;

// executes a given command in the terminal
public class ExecuteCommand extends AbstractSingleCommand {
  private static final String id = "EXECUTE";

  String system_command;

  public ExecuteCommand(String m_system_command) {
    system_command = m_system_command;
  }

  @Override
  public void execute(Environment envi) throws ExecException {
    envi.executeSystem(system_command);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    return new ExecuteCommand(scanner.nextLine());
  }

  @Override
  public String getStringRepresentation() {
    return id + ' ' + system_command;
  }

  public static void main(String[] args) {
    ProgramBuilder program = new ProgramBuilder();
    program.addCommand(new ExecuteCommand("wsl psql -c 'select * from tab' > tempo.txt"));
    Environment envi = new DesktopEnvironment(program.getProgram());
    envi.runProgram();
  }

  @Override
  public String getPattern() {
    return "EXECUTE command";
  }
}
