package util.builders;

import lang.CodeFragment;

public interface Builder<T extends CodeFragment> extends Iterable<T> {
    
    /**
     * Casts content of Builder into regular array.
     * @return array of Commands inside Builder.
     */
    T[] toArray();

    /**
     * Append element to the end of the block.
     * @param element command to be added.
     */
    void append(T element);

    /**
     * Insert element at given index.
     * @param element element to be inserted.
     * @param ind mentioned index.
     */
    void insertInto(T element, int ind);

    /**
     * Returns actual size of BlockBuilder.
     * @return size of block.
     */
    int size();

    /**
     * Method showing string representation of elements in Builder.
     */
    void viewContentFull();

    /**
     * Method showing IDs of elements in Builder.
     */
    void viewContentId();
}
