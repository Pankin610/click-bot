package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

public final class While extends GroupCommand {
    private static final String id = "WHILE";
    private final Condition condition;
    public While(Command[] commands, Condition condition){
        super(commands);
        this.condition = condition;
    }
    public While(BlockBuilder commands, Condition condition){
        this(commands.toArray(),condition);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        try {
            while (condition.eval(envi)) executeBlock(envi);
        }
        catch(EvaluationException ex){
            throw new ExecException(ex);
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
