package program;

import files.reading.ReadFileObject;
import files.writing.WriteFileObject;
import lang.commands.Command;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import util.builders.ProgramBuilder;

import java.io.IOException;

/**
 * Implementation of Program functionality. Instances of this class are immutable, with all fields 'final' (and private),
 * Whole part of constructing is handled by ProgramBuilder class.
 */

public final class ProgramDescription implements Program {
  private final Command[] commands;
  private final VariableDescription[] variables;
  private final String name;

  /**
   * Creating Program instance basing on ProgramBuilder.
   *
   * @param program description of Program in ProgramBuilder.
   */
  public ProgramDescription(ProgramBuilder program) {
    name = program.programName;
    final VariableDescription[] vars = program.getVariablesDescription();
    final Command[] comms = program.getCommands();
    variables = new VariableDescription[vars.length];
    System.arraycopy(vars, 0, variables, 0, vars.length);
    commands = new Command[comms.length];
    System.arraycopy(comms, 0, commands, 0, comms.length);
  }

  /**
   * Creating Program instance basing on file description.
   *
   * @param file with program description.
   */
  public ProgramDescription(ReadFileObject file) {
    this(new ProgramBuilder(file));
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Variable[] getVariables() {
    Variable[] res = new Variable[variables.length];
    for (int i = 0; i < variables.length; i++) res[i] = variables[i].getVariable();
    return res;
  }

  @Override
  public int getNumOfVariables() {
    return variables.length;
  }

  @Override
  public Command[] getCommands() {
    return commands;
  }

  @Override
  public int getNumOfCommands() {
    return commands.length;
  }

  public void saveToFile(WriteFileObject file) throws IOException {
    file.saveToFile(this);
  }
}
