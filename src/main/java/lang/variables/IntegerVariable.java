package lang.variables;

import exceptions.IncomparableVariablesException;
import lang.CodeFragment;

import java.util.ListIterator;
import java.util.Objects;

public final class IntegerVariable extends AbstractVariable {
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
    @Override
    public boolean isLessThan(Variable other) throws IncomparableVariablesException {
        if(other instanceof IntegerVariable){
            return this.getValue()<((IntegerVariable) other).getValue();
        }
        throw new IncomparableVariablesException(this.getName(),other.getName());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof IntegerVariable)    return val.equals(((IntegerVariable) o).val);
        if(o instanceof Integer)            return val.equals(o);
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
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
}
