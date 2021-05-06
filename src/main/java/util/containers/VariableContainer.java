package util.containers;

import lang.variables.Variable;

import java.util.List;

/**
 * A class for storing and accessing variables inside scripts.
 * Should be stored in an Environment object.
 */

public interface VariableContainer extends List<Variable> {
  // every variable container should support these basic functions
  void addAll(Variable... vars);

  void remove(Variable var);

  void remove(String name);

  Variable get(String name);

  Variable[] toArray();
}
