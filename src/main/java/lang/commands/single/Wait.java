package lang.commands.single;

import environments.Environment;
import lang.commands.SingleCommand;

public class Wait extends SingleCommand {
    private final int tim;
    public Wait(int m_tim){
        tim = m_tim;
    }
    @Override
    public void exec(Environment envi) {
        envi.wait(tim);
    }
}
