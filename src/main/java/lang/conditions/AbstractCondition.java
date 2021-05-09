package lang.conditions;

import exceptions.NonImplementedMethodException;
import lang.AbstractCodeFragment;
import util.gui.CodeItem;

public abstract class AbstractCondition extends AbstractCodeFragment implements Condition {
    @Override
    public CodeItem getCodeItem() {
        throw new NonImplementedMethodException("getCodeItem " + this.getClass());
    }
}
