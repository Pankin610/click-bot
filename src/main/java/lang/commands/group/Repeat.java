package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.builders.BlockBuilder;

public final class Repeat extends GroupCommand {
    private static final String id = "REPEAT";
    private final int num;
    public Repeat(Command[] commands, int num){
        super(commands);
        this.num = num;
    }
    public Repeat(BlockBuilder commands, int num){
        this(commands.toArray(),num);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        for (int i = 0; i < num; i++) commands.execute(envi);
    }

    @Override
    public String getId() {
        return id;
    }
}
