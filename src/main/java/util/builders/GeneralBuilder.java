package util.builders;

import lang.CodeFragment;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * General class used to build blocks of Commands or Variables. It should behave similarly to StringBuilder.
 * It is preferable to use specialized classes (ProgramBuilder, BlockBuilder) whenever possible,
 * as these are friendlier to use.
 */

public final class GeneralBuilder<T extends CodeFragment> implements Builder<T> {
  private final LinkedList<T> list;
  private final Class<T[]> aClass;
  private final Class<T> tClass;

  /**
   * Builder should be initiated with parameter of Array type (strong-type checking is implemented).
   * Usage: new Builder<>(ClassName.class, ClassName[].class) - [] symbol is crucial!
   * For example: Builder<Command> my_builder = new Builder<>(Command.class, Command[].class);
   *
   * @param tClass Type of class which should be kept in a Builder.
   * @param aClass Array type of tClass.
   */
  public GeneralBuilder(Class<T> tClass, Class<T[]> aClass) {
    this.tClass = tClass;
    this.aClass = aClass;
    list = new LinkedList<>();
  }

  @Override
  public Iterator<T> iterator() { /* later may be changed to listIterator */
    return list.iterator();
  }

  /**
   * Casts content to array form.
   *
   * @return array with elements of Builder.
   */
  @Override
  public T[] toArray() {
    T[] res = aClass.cast(Array.newInstance(tClass, list.size()));
    int ind = 0;
    for (T element : list) res[ind++] = element;
    return res;
  }

  /**
   * Append element to the end of the block.
   *
   * @param element command to be added.
   */
  @Override
  public void append(T element) {
    list.add(element);
  }

  /**
   * Insert element at given index.
   *
   * @param element element to be inserted.
   * @param ind     mentioned index.
   */
  @Override
  public void insertInto(T element, int ind) {
    if (ind >= list.size()) throw new IndexOutOfBoundsException();
    list.add(ind, element);
  }

  /**
   * Returns actual size of BlockBuilder.
   *
   * @return size of block.
   */
  @Override
  public int size() {
    return list.size();
  }

  /**
   * Method showing string representation of elements in Builder.
   */
  @Override
  public void viewContentFull() {
    for (T element : list) {
      System.out.println(element.getStringRepresentation());
    }
  }

  /**
   * Method showing IDs of elements in Builder.
   */
  @Override
  public void viewContentId() {
    for (T element : list) {
      System.out.println(element.getId());
    }
  }
}
