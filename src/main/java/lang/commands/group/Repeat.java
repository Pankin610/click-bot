package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.builders.BlockBuilder;

import java.util.Scanner;

public final class Repeat extends AbstractGroupCommand {
  private static final String id = "REPEAT";
  private final int num;

  public Repeat(Command[] commands, int num) {
    super(commands);
    this.num = num;
  }

  public Repeat(BlockBuilder commands, int num) {
    this(commands.toArray(), num);
  }

  @Override
  public void execute(Environment envi) throws ExecException {
    for (int i = 0; i < num; i++) executeBlock(envi);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Command parseFromString(Scanner scanner) {
    int num_com = scanner.nextInt();
    int num_rep = scanner.nextInt();
    BlockBuilder block = new BlockBuilder();
    block.parseFromString(scanner, num_com);
    return new Repeat(block, num_rep);
  }

  @Override
  public String getStringRepresentation() {
    StringBuilder res = new StringBuilder(getId() + ' ' + commands.length + '\n');
    res.append(num);
    for (Command com : commands) {
      res.append('\n');
      res.append(com.getStringRepresentation());
    }
    return res.toString();
  }
}
