package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

public final class IfCondition extends GroupCommand {
    private static final String id = "IF_CONDITION";
    private final Condition condition;
    public IfCondition(Command[] commands, Condition condition){
        super(commands);
        this.condition = condition;
    }
    public IfCondition(BlockBuilder commands, Condition condition){
        this(commands.toArray(),condition);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        try {
            if (condition.eval(envi)) commands.execute(envi);
        }
        catch(EvaluationException e){
            throw new ExecException(e);
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
