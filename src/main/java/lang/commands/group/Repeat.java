package lang.commands.group;

import environments.Environment;
import lang.commands.BlockCommand;
import lang.commands.Command;
import lang.commands.single.Nothing;

public class Repeat extends BlockCommand {
    private final int num;
    public Repeat(Command[] m_coms, int m_num){
        if(m_coms == null) {
            num = m_num;
            coms = new Command[1];
            coms[0] = new Nothing();
            return;
        }
        num = m_num;
        coms = new Command[m_coms.length];
        System.arraycopy(m_coms, 0, coms, 0, m_coms.length);
    }
    @Override
    public void exec(Environment envi) {
        for(Command com : coms) com.exec(envi);
    }
}
