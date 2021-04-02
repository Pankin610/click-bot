package lang.conditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.CodeFactory;

import java.util.Scanner;

public final class Not extends AbstractCondition {
    private static final String id = "NOT";
    private final Condition condition;
    public Not(Condition m_condition){
        condition = m_condition;
    }

    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        return !condition.eval(envi);
    }

    @Override
    public String getStringRepresentation() {
        return "NOT " + condition.getStringRepresentation();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Condition parseFromString(Scanner scanner) {
        return new Not(CodeFactory.parseCondition(scanner));
    }
}
