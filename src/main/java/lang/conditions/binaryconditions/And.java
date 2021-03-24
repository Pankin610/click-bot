package lang.conditions.binaryconditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.conditions.Condition;

public final class And extends BinaryCondition {
    private static final String id = "AND";
    public And(Condition m_condition1, Condition m_condition2) {
        super(m_condition1, m_condition2);
    }
    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        return condition1.eval(envi) && condition2.eval(envi);
    }

    @Override
    public String getId() {
        return id;
    }
}
