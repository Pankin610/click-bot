package lang.variables;

import exceptions.NoUniqueVariableNameException;
import exceptions.NoVariableWithThisNameException;

import java.util.ArrayList;

/*
A class for storing and accessing variables inside scripts.
Should be stored in an Environment object.
 */

public interface VariableContainer {
    // every variable container should support these basic functions
    public void add(Variable v);
    public void remove(Variable v);
    public Variable get(String name);
}
