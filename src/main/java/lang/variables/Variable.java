package lang.variables;

import exceptions.IncomparableVariablesException;
import lang.CodeFragment;

public interface Variable extends CodeFragment {
    Object getValue();
    String getName();
    void setValue(Object value);
}
