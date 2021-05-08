package util.containers;

import javafx.collections.ObservableList;
import lang.variables.Variable;

/**
 * A class for storing and accessing variables inside scripts.
 * Should be stored in an Environment object.
 */

public interface VariableContainer extends ObservableList<Variable> {
  // every variable container should support these basic functions
  void remove(String name);
  Variable get(String name);
}
