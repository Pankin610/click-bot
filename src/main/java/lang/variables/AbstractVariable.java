package lang.variables;

import exceptions.IncomparableVariablesException;
import exceptions.NonImplementedMethodException;
import lang.AbstractCodeFragment;

public abstract class AbstractVariable extends AbstractCodeFragment implements Variable {
    private final String name;
    protected AbstractVariable(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public boolean isLessThan(Variable other) {
        throw new IncomparableVariablesException(this.getName(), other.getName());
    }

    @Override
    public Object getValue() {
        throw new NonImplementedMethodException("getValue");
    }
}
