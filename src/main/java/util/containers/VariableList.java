package util.containers;

import exceptions.NoUniqueVariableNameException;
import exceptions.NoVariableWithThisNameException;
import lang.variables.Variable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Implementation of VariableContainer interface.
 */

public class VariableList implements VariableContainer {
    private final ArrayList<Variable> variables = new ArrayList<>();

    @Override
    public void add(Variable v) {
        if (v == null) {
            throw new NullPointerException();
        }
        // checking if there is a variable with the same name
        if(checkSameNameVariable(v.getName()))  throw new NoUniqueVariableNameException(v.getName());
        variables.add(v);
    }

    @Override
    public void addAll(Variable... vars){
        Collections.addAll(variables, vars);
    }

    private boolean checkSameNameVariable(String name){
        for (Variable var : variables) {
            if (name.equals(var.getName())) {
                return true;
            }
        }
        return false;
    }

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

    @Override
    public Variable[] toArray(){
        Variable[] res = new Variable[variables.size()];
        int ind = 0;
        for(Variable var : variables)   res[ind++] = var;
        return res;
    }

    @Override
    public Iterator<Variable> iterator() {
        return variables.iterator();
    }
}
