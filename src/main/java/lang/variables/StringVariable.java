package lang.variables;

import exceptions.IncomparableVariablesException;
import exceptions.IncorrectVariableAssignment;
import lang.CodeFragment;

import java.util.Scanner;

public final class StringVariable extends AbstractVariable {
    private static final String id = "STR"; // can be changed to STRING if needed
    private String val;
    public StringVariable(String m_name, String m_val) {
        super(m_name);
        val = m_val;
    }
    @Override
    public String getValue() {
        return val;
    }

    @Override
    public String getStringRepresentation() {
        return "STR " + getName() + " " + val;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CodeFragment parseFromString(Scanner scanner) {
        return null;
    }

    // regular java objects serve the role of literals
    @Override
    public void setValue(Object value) {
        if (value instanceof StringVariable) {
            val = ((StringVariable)value).getValue();
        }
        if (value instanceof String) {
            val = (String)value;
        }
        if (value instanceof IntegerVariable) {
            val = value.toString();
        }
        throw new IncorrectVariableAssignment(this, value);
    }

    public Integer toInteger() {
        return Integer.parseInt(val);
    }

    @Override
    public String getId() {
        return id;
    }

    // simple comparator
    // could implement comparing with regular Strings but that would be asymmetric
    @Override
    public int compareTo(Variable other) {
        if(other instanceof StringVariable){
            String this_value = this.getValue();
            String other_value = ((StringVariable) other).getValue();
            return this_value.compareTo(other_value);
        }
        throw new IncomparableVariablesException(this.getName(),other.getName());
    }
}
