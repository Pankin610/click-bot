package lang.variables;

import exceptions.IncomparableVariablesException;

public class StringVariable extends AbstractVariable implements Comparable<StringVariable> {
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
    public boolean isLessThan(Variable other) throws IncomparableVariablesException {
        // this will probably get removed later
        return false;
    }
    @Override
    public int compareTo(StringVariable other) {
        String this_value = getValue();
        String other_value = other.getValue();
        return this_value.compareTo(other_value);
    }

    @Override // TODO useless override
    public String getId() {
        return id;
    }
}
