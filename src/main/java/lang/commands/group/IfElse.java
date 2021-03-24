package lang.commands.group;

import environments.Environment;
import exceptions.EvaluationException;
import exceptions.ExecException;
import lang.commands.Command;
import lang.conditions.Condition;
import util.builders.BlockBuilder;

public final class IfElse extends BlockCommand {
    private static final String id = "IF_ELSE";
    private final Command[] commands2;
    private final Condition condition;
    public IfElse(Command[] m_commands, Command[] m_commands2, Condition m_condition){
        super(m_commands);
        commands2 = new Command[m_commands2.length];
        System.arraycopy(m_commands2,0,commands2,0,m_commands2.length);
        condition = m_condition;
    }
    public IfElse(BlockBuilder m_commands1, BlockBuilder m_commands2, Condition m_condition){
        this(m_commands1.toArray(),m_commands2.toArray(),m_condition);
    }

    @Override
    public void execute(Environment envi) throws ExecException {
        try {
            if (condition.eval(envi))
                for (Command com : commands)
                    com.execute(envi);
            else
                for (Command com : commands2)
                    com.execute(envi);
        } catch (ExecException | EvaluationException e) {
            throw new ExecException(e.getMessage());
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
