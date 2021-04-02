package lang.conditions;

import environments.Environment;
import lang.CodeFactory;

import java.util.Scanner;

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
    @SuppressWarnings("unchecked")
    public Condition parseFromString(Scanner scanner) {
        return CodeFactory.FALSE;
    }

    @Override
    public String getId() {
        return id;
    }
}
