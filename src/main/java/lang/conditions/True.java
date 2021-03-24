package lang.conditions;

import environments.Environment;
import lang.CodeFactory;
import lang.CodeFragment;

import java.util.ListIterator;

public final class True implements Condition {
    private static final String id = "TRUE";
    @Override
    public boolean eval(Environment envi) {
        return true;
    }

    @Override
    public String getStringRepresentation() {
        return "TRUE";
    }

    @Override
    public CodeFragment parseFromString(ListIterator<String> lines) {
        lines.next();
        return CodeFactory.TRUE;
    }

    @Override
    public String getId() {
        return id;
    }
}
