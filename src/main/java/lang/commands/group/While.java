package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

public final class While extends BlockCommand {
    private static final String id = "WHILE";
    private final Condition condition;
    public While(Command[] m_commands, Condition m_condition){
        super(m_commands);
        condition = m_condition;
    }
    public While(BlockBuilder m_commands, Condition m_condition){
        this(m_commands.toArray(),m_condition);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        try {
            while (condition.eval(envi)) {
                for (Command com : commands) com.execute(envi);
            }
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
