package lang.commands.single;

import environments.Environment;

public class ScrollCommand extends AbstractSingleCommand {
    private static final String id = "SCROLL";
    private final Integer where;
    public ScrollCommand(int where) {
        this.where = where;
    }

    @Override
    public void execute(Environment envi) {
        envi.scroll(where);
    }

    @Override
    public String getId() {
        return id;
    }
}
