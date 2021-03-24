package lang.variables;

import exceptions.IncomparableVariablesException;

public abstract class AbstractVariable implements Variable {
    private final String name;
    protected AbstractVariable(String m_name){
        name = m_name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public boolean isLessThan(Variable other) throws IncomparableVariablesException {
        throw new IncomparableVariablesException(this.getName(), other.getName());
    }
}
