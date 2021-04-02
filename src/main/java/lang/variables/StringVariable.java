package lang.variables;

import exceptions.IncorrectVariableAssignment;
import lang.CodeFragment;

import java.util.ListIterator;

public final class StringVariable extends AbstractVariable implements Comparable<StringVariable> {
    private static final String id = "STR"; // can be changed to STRING if needed
    private String val = "";
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
    public CodeFragment parseFromString(ListIterator<String> lines) {
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

    // simple comparator
    // could implement comparing with regular Strings but that would be asymmetric
    public int compareTo(StringVariable other) {
        String this_value = getValue();
        String other_value = other.getValue();
        return this_value.compareTo(other_value);
    }

    public Integer toInteger() {
        return Integer.parseInt(val);
    }

    @Override
    public String getId() {
        return id;
    }
}
