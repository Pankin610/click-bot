package util.builders;

import exceptions.NoUniqueVariableNameException;
import exceptions.WrongFileFormatException;
import files.reading.ReadFileObject;
import files.writing.WriteFileObject;
import javafx.scene.control.TreeItem;
import lang.CodeFactory;
import lang.commands.Command;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import program.Program;
import program.ProgramDescription;
import util.containers.VariableContainer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class used to build programs. Can be used later in Program's constructor.
 */

public final class ProgramBuilder {
  private final Builder<VariableDescription> variables = new GeneralBuilder<>(VariableDescription.class, VariableDescription[].class);
  private final Builder<Command> commands = new GeneralBuilder<>(Command.class, Command[].class);
  public String programName;

  public ProgramBuilder() {
  }

  /**
   * Creates ProgramBuilder basing on file description of program.
   * @param file with description of the program.
   */
  public ProgramBuilder(ReadFileObject file) {
    this(file.getScanner());
  }

  public ProgramBuilder(Scanner scanner){
    if (!"PROGRAM".equals(scanner.next())) throw new WrongFileFormatException("Program preamble");
    programName = scanner.next();
    loadVariables(scanner);
    loadCommands(scanner);
  }

  public void loadVariables(Scanner scanner){
    if (!"VARIABLES".equals(scanner.next())) throw new WrongFileFormatException("Variables preamble");
    int num = scanner.nextInt();
    for (int i = 0; i < num; i++) {
      addVariable(new VariableDescription(CodeFactory.parseVariable(scanner)));
    }
  }

  public void loadCommands(Scanner scanner){
    if (!"COMMANDS".equals(scanner.next())) throw new WrongFileFormatException("Commands preamble");
    int num = scanner.nextInt();
    for (int i = 0; i < num; i++) {
      addCommand(CodeFactory.parseCommand(scanner));
    }
  }

  public ProgramBuilder(TreeItem<Command> root, VariableContainer vars) {
    this.programName = root.getValue().getId();
    for (TreeItem<Command> item : root.getChildren()) {
      this.addCommand(item.getValue().parseFromTree(item));
    }
    for (Variable var : vars) {
      this.addVariable(new VariableDescription(var));
    }
  }

  /**
   * @return commands in form of array.
   */
  public Command[] getCommands() {
    return commands.toArray();
  }

  /**
   * @return variables description in form of array.
   */
  public VariableDescription[] getVariablesDescription() {
    return variables.toArray();
  }

  /**
   * Add Variable to the list of variables. Checks for uniqueness of variables' names.
   *
   * @param variable variable to be added.
   */
  public void addVariable(VariableDescription variable) throws NoUniqueVariableNameException {
    if (checkIfContains(variable.getName())) throw new NoUniqueVariableNameException(variable.getName());
    variables.append(variable);
  }

  private boolean checkIfContains(String name) {
    for (VariableDescription var : variables) if (name.equals(var.getName())) return true;
    return false;
  }

  /**
   * Add Commands to the end of list of Commands.
   *
   * @param command commands to be appended.
   */
  public void addCommand(Command command) {
    commands.append(command);
  }

  /**
   * View current list of Variables.
   */
  public void viewVariablesFull() {
    variables.viewContentFull();
  }


  /**
   * View id's of commands in the Builder.
   */
  public void viewVariablesId() {
    variables.viewContentId();
  }

  /**
   * View current list of Commands.
   */
  public void viewCommands() {
    commands.viewContentFull();
  }

  /**
   * View id's of commands in the Builder.
   */
  public void viewCommandsId() {
    commands.viewContentId();
  }

  public void saveToFile(WriteFileObject file) throws IOException {
    file.saveToFile(new ProgramDescription(this));
  }

  public Program getProgram(){
    return new ProgramDescription(this);
  }
}
