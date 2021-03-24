package lang.commands.group;

import environments.Environment;
import exceptions.ExecException;
import lang.commands.Command;
import util.builders.BlockBuilder;

public final class Repeat extends BlockCommand {
    private static final String id = "REPEAT";
    private final int num;
    public Repeat(Command[] m_commands, int m_num){
        super(m_commands);
        num = m_num;
    }
    public Repeat(BlockBuilder m_commands, int m_num){
        this(m_commands.toArray(),m_num);
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        for (int i = 0; i < num; i++) {
            for (Command com : commands) com.execute(envi);
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
