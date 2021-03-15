package lang.commands.single;

import environments.Environment;
import lang.commands.SingleCommand;
import util.Pair;

public class Move extends SingleCommand {
    private final Pair where;
    public Move(Pair m_where){
        where = m_where;
    }
    @Override
    public void exec(Environment envi) {
        envi.moveMouse(where);
    }
}
