package lang.commands.single.variables;

import environments.Environment;
import lang.commands.Command;
import lang.commands.single.AbstractSingleCommand;
import lang.variables.Variable;

import java.util.Scanner;

public class SetCommand extends AbstractSingleCommand {
  private final static String id = "SET";

  String variable_name;
  Integer value;
  public SetCommand(String variable_name, Integer value) {
    this.variable_name = variable_name;
    this.value = value;
  }

  @Override
  public void execute(Environment envi) {
    Variable var = envi.getVarByName(variable_name);
    var.setValue(value);
  }

  @Override
  public String getStringRepresentation() {
    return id + " " + variable_name +  ' ' + value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    String name = scanner.next();
    Integer integer = scanner.nextInt();
    return new SetCommand(name, integer);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getPattern() {
    return "SET var_name value";
  }
}
