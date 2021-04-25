package lang.conditions;

import lang.conditions.binaryconditions.And;
import lang.conditions.binaryconditions.Or;
import lang.conditions.binaryrelations.*;

/**
 * Enum for all final implementation of Condition interface.
 */
public enum Conditions {
    TRUE(True.TRUE),
    FALSE(False.FALSE),
    NOT(new Not(True.TRUE)),
    AND(new And(True.TRUE,True.TRUE)),
    OR(new Or(True.TRUE,True.TRUE)),
    EQUAL(new Equal(null, null)),
    NOT_EQUAL(new NotEqual(null,null)),
    LESS(new Less(null,null)),
    LESS_OR_EQUAL(new LessOrEqual(null,null)),
    GREATER(new Greater(null,null)),
    GREATER_OR_EQUAL(new GreaterOrEqual(null,null));

    private final Condition cond;
    Conditions(Condition cond){
        this.cond = cond;
    }

    public Condition get(){
        return cond;
    }
}
