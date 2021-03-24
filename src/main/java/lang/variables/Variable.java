package lang.variables;

import exceptions.IncomparableVariablesException;
import lang.CodeFragment;

public interface Variable extends CodeFragment {
    Object getValue();
    String getName();
    boolean isLessThan(Variable other) throws IncomparableVariablesException;
}
