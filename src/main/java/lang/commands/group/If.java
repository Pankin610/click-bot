package lang.commands.group;

import environments.Environment;
import lang.commands.BlockCommand;
import lang.commands.Command;
import lang.conditions.Condition;

public class If extends BlockCommand {
    private final Condition cond;
    public If(Condition m_cond){
        cond = m_cond;
    }
    @Override
    public void exec(Environment envi){
        if(cond.eval()) for(Command com : coms) com.exec(envi);
    }
}
