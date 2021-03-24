package lang.conditions.binaryrelations;

import lang.conditions.AbstractCondition;

/**
 * General class representing behaviour of binary relation between variables (like equality etc..)
 */

public abstract class BinaryRelation extends AbstractCondition {
    protected final String variable1;
    protected final String variable2;
    protected BinaryRelation(String m_variable1, String m_variable2){
        variable1 = m_variable1;
        variable2 = m_variable2;
    }
}
