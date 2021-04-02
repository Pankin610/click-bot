package lang.variables;

import exceptions.IncomparableVariablesException;

import java.util.Objects;

public abstract class AbstractVariable implements Variable {
    private final String name;
    protected AbstractVariable(String m_name){
        name = m_name;
    }
    @Override
    public String getName(){
        return name;
    }
    // the default equals method, compares considering the variable name
    // to compare variables by value use the getValue method
    @Override
    public boolean equals(Object other) {
        if (other instanceof AbstractVariable) {
            return getValue().equals(((StringVariable) other).getValue()) &&
                    getName().equals(((StringVariable)other).getName());
        }
        return false;
    }
    // same with hashing, it considers the name of the variable
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }
}
