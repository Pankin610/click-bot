package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.CodeFactory;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

import java.util.Scanner;

public final class While extends AbstractGroupCommand {
  private static final String id = "WHILE";
  private final Condition condition;

  public While(Command[] commands, Condition condition) {
    super(commands);
    this.condition = condition;
  }

  public While(BlockBuilder commands, Condition condition) {
    this(commands.toArray(), condition);
  }

  @Override
  public void execute(Environment envi) throws ExecException {
    try {
      while (condition.eval(envi)) executeBlock(envi);
    } catch (EvaluationException ex) {
      throw new ExecException(ex);
    }
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    int num = scanner.nextInt();
    Condition con = CodeFactory.parseCondition(scanner);
    BlockBuilder block = new BlockBuilder();
    block.parseFromString(scanner, num);
    return new While(block, con);
  }

  @Override
  public String getStringRepresentation() {
    StringBuilder res = new StringBuilder(getId() + ' ' + commands.length + '\n');
    res.append(condition.getStringRepresentation());
    for (Command com : commands) {
      res.append('\n');
      res.append(com.getStringRepresentation());
    }
    return res.toString();
  }
}
