package util.containers;

import lang.variables.Variable;

/**
 * A class for storing and accessing variables inside scripts.
 * Should be stored in an Environment object.
 */

public interface VariableContainer extends Iterable<Variable>{
    // every variable container should support these basic functions
    void add(Variable var);
    void addAll(Variable... vars);
    void remove(Variable var);
    Variable get(String name);
    Variable[] toArray();
}
