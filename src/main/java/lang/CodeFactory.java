package lang;

import exceptions.InvalidIdException;
import lang.commands.Command;
import lang.commands.Commands;
import lang.conditions.Condition;
import lang.conditions.Conditions;
import lang.variables.Variable;
import lang.variables.Variables;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Factory of final implementations of CodeFragment interface.
 * Methods inside this class can parse instance of CodeFragment using description inside Scanner (created from file).
 * Later this may be implemented using reflections.
 */

public final class CodeFactory {
  private CodeFactory() {
  }

  public static Variable parseVariable(Scanner scanner) {
    return getVariableByID(scanner.next()).parseFromString(scanner);
  }

  public static Condition parseCondition(Scanner scanner) {
    return getConditionByID(scanner.next()).parseFromString(scanner);
  }

  public static Command parseCommand(Scanner scanner) {
    return getCommandByID(scanner.next()).parseFromString(scanner);
  }

  public static CodeFragment parseCodeFragment(Scanner scanner) {
    return getCodeFragmentByID(scanner.next()).parseFromString(scanner);
  }

  public static Variable parseVariable(String description) {
    return parseVariable(new Scanner(new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8))));
  }

  public static Condition parseCondition(String description) {
    return parseCondition(new Scanner(new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8))));
  }

  public static Command parseCommand(String description) {
    return parseCommand(new Scanner(new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8))));
  }

  public static CodeFragment parseCodeFragment(String description) {
    return parseCodeFragment(new Scanner(new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8))));
  }

  private static final HashMap<String, Variable> varMap = new HashMap<>();
  private static final HashMap<String, Condition> condMap = new HashMap<>();
  private static final HashMap<String, Command> commMap = new HashMap<>();

  static {
    for (Variables var : Variables.values()) {
      varMap.put(var.get().getId(), var.get());
    }
    for (Conditions cond : Conditions.values()) {
      condMap.put(cond.get().getId(), cond.get());
    }
    for (Commands comm : Commands.values()) {
      commMap.put(comm.get().getId(), comm.get());
    }
  }

  public static Variable getVariableByID(String ID) {
    if (!varMap.containsKey(ID)) throw new InvalidIdException(ID);
    return varMap.get(ID);
  }

  public static Condition getConditionByID(String ID) {
    if (!condMap.containsKey(ID)) throw new InvalidIdException(ID);
    return condMap.get(ID);
  }

  public static Command getCommandByID(String ID) {
    if (!commMap.containsKey(ID)) throw new InvalidIdException(ID);
    return commMap.get(ID);
  }

  public static CodeFragment getCodeFragmentByID(String ID) {
    if (varMap.containsKey(ID)) return varMap.get(ID);
    if (condMap.containsKey(ID)) return condMap.get(ID);
    if (commMap.containsKey(ID)) return commMap.get(ID);
    throw new InvalidIdException(ID);
  }

}
