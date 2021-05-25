package lang.commands.var_manipulation;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import lang.commands.single.AbstractSingleCommand;
import lang.variables.Addable;
import lang.variables.Variable;

import java.util.Scanner;

import util.Parsing;

public class AddCommand<T> extends AbstractSingleCommand {
  private final static String id = "ADD";

  String variable_name;
  T to_add;
  public AddCommand(String var_name, T m_to_add) {
    variable_name = var_name;
    to_add = m_to_add;
  }
  @Override
  public void execute(Environment envi) throws ExecException {
    Variable var = envi.getVarByName(variable_name);
    if (var instanceof Addable) {
      try {
        Addable<T> addable = (Addable<T>) var;
        addable.add(to_add);
      }
      catch (ClassCastException e) {
        throw new ExecException("The variable can't add this.", e);
      }
    }
    else {
      throw new ExecException("The variable doesn't support adding");
    }
  }

  @Override
  public String getStringRepresentation() {
    return id + " " + variable_name + Parsing.parseLiteral(to_add);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Command parseFromString(Scanner scanner) {
    throw new UnsupportedOperationException(); // TODO
  }

  @Override
  public String getId() {
    return id;
  }
}
