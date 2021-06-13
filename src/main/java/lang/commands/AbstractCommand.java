package lang.commands;

import lang.AbstractCodeFragment;

/**
 * Abstract implementation of Command interface.
 */

public abstract class AbstractCommand extends AbstractCodeFragment implements Command {
    @Override
    public String toString() {
        return getId();
    }

    @Override
    public String getPattern() {
        return getId();
    }
}
