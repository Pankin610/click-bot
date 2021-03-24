package lang.conditions.binaryconditions;

import environments.Environment;
import exceptions.EvaluationException;
import lang.conditions.Condition;

public final class Or extends BinaryCondition {
    private static final String id = "OR";
    public Or(Condition m_condition1, Condition m_condition2) {
        super(m_condition1, m_condition2);
    }
    @Override
    public boolean eval(Environment envi) throws EvaluationException {
        return condition1.eval(envi) || condition2.eval(envi);
    }

    @Override
    public String getId() {
        return id;
    }
}
