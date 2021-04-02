package lang.conditions;

import environments.Environment;
import lang.CodeFactory;

import java.util.Scanner;

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
    @SuppressWarnings("unchecked")
    public Condition parseFromString(Scanner scanner) {
        return CodeFactory.TRUE;
    }

    @Override
    public String getId() {
        return id;
    }
}
