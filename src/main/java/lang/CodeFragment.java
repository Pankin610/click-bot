package lang;

import exceptions.NonImplementedMethodException;

import java.util.HashMap;
import java.util.ListIterator;

/**
 * This interface represents everything what can be used to build a Program.
 * TODO: All default methods should be overrode in every final implementation of this interface,
 * TODO: then default key word should be removed.
 */
public interface CodeFragment {

    /**
     * This method should return a representation of an instance of the CodeFragment
     * as the String (to be saved in the file).
     * @return default 'dummy' representation
     */
    default String getStringRepresentation(){
        return "Method getStringRepresentation is not implemented";
    }

    /**
     * This method should describe how to created a instance of corresponding CodeFragment's implementation
     * from String representation.
     * @param lines iterator to lines, in which representation of CodeFragment is saved.
     * @return proper instance of CodeFragment's implementation.
     */
    default CodeFragment parseFromString(ListIterator<String> lines) {
        return null;
    }

    /**
     * Every final implementation of this interface should contain static field with unique ID,
     * which this method should return.
     * @return ID of corresponding class.
     */
    default String getId() {
        return "Method getId is not implemented";
    }
}
