package lang.commands.single;

import lang.commands.AbstractCommand;
import util.gui.CodeItem;

/**
 * Abstract implementation of SingleCommand interface.
 */
public abstract class AbstractSingleCommand extends AbstractCommand implements SingleCommand {
    @Override
    public CodeItem getTreeRepresentation() {
        CodeItem res = new CodeItem(this);
        res.setValue(this.getStringRepresentation());
        return res;
    }
}
