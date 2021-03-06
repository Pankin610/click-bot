package util.containers;

import exceptions.NoUniqueVariableNameException;
import exceptions.NoVariableWithThisNameException;
import javafx.collections.ObservableListBase;
import lang.variables.Variable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

/**
 * Implementation of VariableContainer interface.
 */
public class VariableList extends ObservableListBase<Variable> implements VariableContainer {
  private final ArrayList<Variable> variables = new ArrayList<>();

  @Override
  public boolean add(Variable v) {
    Objects.requireNonNull(v, "null variable inside VariableContainer::add method");
    // checking if there is a variable with the same name
    if (checkNameVariable(v.getName())) throw new NoUniqueVariableNameException(v.getName());
    return variables.add(v);
  }

  @Override
  public Variable get(int index) {
    return variables.get(index);
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
  public void remove(String name) {
    if (!checkNameVariable(name)) throw new NoVariableWithThisNameException(name);
    variables.remove(this.get(name));
  }

  private boolean checkNameVariable(String name) {
    for (Variable var : variables) {
      if (name.equals(var.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public int size() {
    return variables.size();
  }

  @Override
  public Iterator<Variable> iterator() {
    return variables.iterator();
  }

  @Override
  public ListIterator<Variable> listIterator() {
    return variables.listIterator();
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void clear() {
    variables.clear();
  }
}
