package lang.commands.single;

import environments.Environment;
import exceptions.ExecException;

public class ScrollCommand extends AbstractSingleCommand {
    private static final String id = "SCROLL";
    private final Integer where;
    public ScrollCommand(int m_where) {
        where = m_where;
    }
    @Override
    public void execute(Environment envi) throws ExecException {
        envi.scroll(where);
    }
    @Override // TODO make a common single command method?
    public String getId() {
        return id;
    }
}
