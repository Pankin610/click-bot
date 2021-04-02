package lang.variables;

import exceptions.IncomparableVariablesException;
import exceptions.IncorrectVariableAssignment;
import lang.CodeFragment;

import java.util.ListIterator;
import java.util.Objects;

public final class IntegerVariable extends AbstractVariable implements Comparable<IntegerVariable> {
    private static final String id = "INT";
    private Integer val;
    public IntegerVariable(String m_name, Integer m_val){
        super(m_name);
        val = m_val;
    }
    @Override
    public Integer getValue(){
        return val;
    }

    // regular java objects serve the role of literals
    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
            val = (Integer) value;
        }
        if (value instanceof IntegerVariable) {
            val = ((IntegerVariable)value).getValue();
        }
        if (value instanceof StringVariable) {
            val = ((StringVariable)value).toInteger();
        }
        throw new IncorrectVariableAssignment(this, value);
    }

    public void changeValue(Integer v){
        val = v;
    }
    public void add(Integer v){
        val += v;
    }
    public void sub(Integer v){
        val -= v;
    }
    public void increment(){
        val++;
    }
    public void decrement(){
        val--;
    }

    @Override
    public String getStringRepresentation() {
        return "INT " + getName() + " " + val;
    }

    @Override
    public CodeFragment parseFromString(ListIterator<String> lines) {
        return null;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int compareTo(IntegerVariable other) {
        return getValue().compareTo(other.getValue());
    }
}
