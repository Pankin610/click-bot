package lang.variables;

import lang.CodeFragment;

public interface Variable extends CodeFragment, Comparable<Variable>{
    Object getValue();
    String getName();
    void setValue(Object value);
}
