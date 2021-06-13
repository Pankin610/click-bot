package lang.commands.single.variables;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import lang.commands.single.AbstractSingleCommand;
import lang.variables.IntegerVariable;
import lang.variables.Variable;

import java.util.Scanner;

public class AddCommand extends AbstractSingleCommand {
  private final static String id = "ADD";

  String variable_name;
  Integer to_add;
  public AddCommand(String var_name, Integer to_add) {
    variable_name = var_name;
    this.to_add = to_add;
  }
  @Override
  public void execute(Environment envi) throws ExecException {
    Variable var = envi.getVarByName(variable_name);
    if (var instanceof IntegerVariable) {
      ((IntegerVariable)var).add(to_add);
    }
  }

  @Override
  public String getStringRepresentation() {
    return id + " " + variable_name + ' ' + to_add;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    String name = scanner.next();
    Integer integer = scanner.nextInt();
    return new AddCommand(name, integer);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getPattern() {
    return "ADD var_name value";
  }
}
