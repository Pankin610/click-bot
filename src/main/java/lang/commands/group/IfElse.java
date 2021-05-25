package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.CodeFactory;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public final class IfElse extends AbstractGroupCommand {
  private static final String id = "IF_ELSE";
  private final Command[] commands2;
  private final Condition condition;

  public IfElse(Command[] commands, Command[] commands2, Condition condition) {
    super(commands);
    this.commands2 = new Command[commands2.length];
    System.arraycopy(commands2, 0, this.commands2, 0, commands2.length);
    this.condition = condition;
  }

  public IfElse(BlockBuilder commands1, BlockBuilder commands2, Condition condition) {
    this(commands1.toArray(), commands2.toArray(), condition);
  }

  @Override
  public void execute(Environment envi) throws ExecException {
    try {
      if (condition.eval(envi)) executeBlock(envi);
      else {
        for (Command command : commands2) command.execute(envi);
      }
    } catch (Exception e) {
      throw new ExecException(e.getMessage());
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getStringRepresentation() {
    StringBuilder res = new StringBuilder(getId() + condition.getStringRepresentation() +'\n');
    parseBlockToString(res);
    res.append("\nELSE {\n");
    for (Command com : commands2) {
      res.append(com.getStringRepresentation());
      res.append('\n');
    }
    res.append('}');
    return res.toString();
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    Condition con = CodeFactory.parseCondition(scanner);
    BlockBuilder ifBlock = new BlockBuilder().parseFromString(scanner);
    scanner.next(); // reading "ELSE"
    BlockBuilder elseBlock = new BlockBuilder().parseFromString(scanner);
    return new IfElse(ifBlock, elseBlock, con);
  }

  @Override
  public Command[] getCommands() {
    return Stream.concat(Arrays.stream(commands), Arrays.stream(commands2)).toArray(Command[]::new);
  }
}
