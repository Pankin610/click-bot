package lang.variables;

import exceptions.NonImplementedMethodException;
import lang.AbstractCodeFragment;

public abstract class AbstractVariable extends AbstractCodeFragment implements Variable{
    private final String name;
    protected AbstractVariable(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Object getValue() {
        throw new NonImplementedMethodException("getValue");
    }

    @Override
    public int compareTo(Variable o) {
        throw new NonImplementedMethodException("compareTo");
    }

    /**
     * Every Variable should use this pattern for parsing.
     * @return String representation of Variable.
     */
    @Override
    final public String getStringRepresentation() {
        return getId() + ' ' + getName() + ' ' + getValue();
    }

    @Override
    public String toString() {
        return getName() + ": " + getValue();
    }
}
