package lang.variables;

import exceptions.NoUniqueVariableNameException;
import exceptions.NoVariableWithThisNameException;

import java.util.ArrayList;

public class VariableList implements VariableContainer {
    private ArrayList<Variable> variables = new ArrayList<>();
    @Override
    public void add(Variable v) {
        if (v == null) {
            throw new NullPointerException();
        }
        // checking if there is a variable with the same name
        for (Variable old : variables) {
            if (old.getName().equals(v.getName())) {
                throw new NoUniqueVariableNameException(old.getName());
            }
        }
        variables.add(v);
    }
    @Override
    public void remove(Variable v) {
        variables.remove(v);
    }
    @Override
    public Variable get(String name) {
        for (Variable var : variables) {
            if (var.getName().equals(name)) {
                return var;
            }
        }
        throw new NoVariableWithThisNameException(name);
    }
}
