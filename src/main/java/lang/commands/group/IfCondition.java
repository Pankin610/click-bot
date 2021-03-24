package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

public final class IfCondition extends BlockCommand {
    private static final String id = "IF_CONDITION";
    private final Condition cond;
    public IfCondition(Command[] m_commands, Condition m_condition){
        super(m_commands);
        cond = m_condition;
    }
    public IfCondition(BlockBuilder m_commands, Condition m_condition){
        this(m_commands.toArray(),m_condition);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        try {
            if (cond.eval(envi)) for (Command com : commands) com.execute(envi);
        }
        catch(EvaluationException e){
            throw new ExecException(e.getMessage());
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
