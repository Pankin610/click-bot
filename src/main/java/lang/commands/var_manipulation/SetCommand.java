package lang.commands.var_manipulation;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import lang.commands.single.AbstractSingleCommand;
import lang.variables.Variable;
import util.Parsing;

import java.util.Scanner;

public class SetCommand extends AbstractSingleCommand {
  private final static String id = "SET";

  String variable_name;
  Object value;
  public SetCommand(String m_variable_name, Object m_value) {
    variable_name = m_variable_name;
    value = m_value;
  }

  @Override
  public void execute(Environment envi) {
    Variable var = envi.getVarByName(variable_name);
    var.setValue(value);
  }

  @Override
  public String getStringRepresentation() {
    return id + " " + variable_name +  ' ' + Parsing.parseLiteral(value);
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
}
