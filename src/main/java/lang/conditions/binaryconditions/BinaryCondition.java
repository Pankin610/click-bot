package lang.conditions.binaryconditions;

import lang.conditions.AbstractCondition;
import lang.conditions.Condition;

/**
 * General class representing behaviour of binary conditions (like AND or OR operator)
 */

public abstract class BinaryCondition extends AbstractCondition {
    protected final Condition condition1;
    protected final Condition condition2;
    protected BinaryCondition(Condition m_condition1, Condition m_condition2){
        condition1 = m_condition1;
        condition2 = m_condition2;
    }
}