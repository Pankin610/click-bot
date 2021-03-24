package lang.conditions;

import environments.Environment;
import lang.CodeFactory;
import lang.CodeFragment;

import java.util.ListIterator;

public final class False implements Condition {
    private static final String id = "FALSE";

    @Override
    public boolean eval(Environment envi) {
        return false;
    }

    @Override
    public String getStringRepresentation() {
        return "FALSE";
    }

    @Override
    public CodeFragment parseFromString(ListIterator<String> lines) {
        lines.next();
        return CodeFactory.FALSE;
    }

    @Override
    public String getId() {
        return id;
    }
}
