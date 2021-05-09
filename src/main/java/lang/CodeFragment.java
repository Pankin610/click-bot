package lang;

import exceptions.NonImplementedMethodException;
import javafx.scene.control.TreeItem;

import java.util.Scanner;

/**
 * This interface represents everything what can be used to build a Program.
 */
public interface CodeFragment {

  /**
   * This method should return a representation of an instance of the CodeFragment
   * as the String (to be saved in the file).
   *
   * @return default 'dummy' representation
   */
  String getStringRepresentation();

  /**
   * This method should describe how to created a instance of corresponding CodeFragment's implementation
   * from String representation.
   *
   * @param scanner of file, in which representation of CodeFragment is saved.
   * @return proper instance of CodeFragment's implementation.
   */
  <T extends CodeFragment> T parseFromString(Scanner scanner);

  /**
   * Every final implementation of this interface should contain static final field with unique ID,
   * which this method should return.
   *
   * @return ID of corresponding class.
   */
  String getId();

  /**
   * This method should describe how Command should be showed as tree node inside project-creation window.
   *
   * @return TreeItem with representation.
   * For now, it may be non implemented.
   */
  default TreeItem<CodeFragment> getTreeRepresentation() {
    throw new NonImplementedMethodException("getTreeRepresentation");
  }

  default CodeFragment parseFromTree(TreeItem<CodeFragment> item) {
    throw new NonImplementedMethodException("parseFromTree");
  }
}
