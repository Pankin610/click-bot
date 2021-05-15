package environments;

import exceptions.ExecException;
import exceptions.NoVariableWithThisNameException;
import lang.variables.Variable;
import util.Coordinate;

import java.awt.*;

/**
 * This interface describes methods which implementation is necessary to make command calls correct.
 */
public interface Environment {
  void runProgram() throws ExecException;

  void pressKey(int key);

  void holdKey(int key);

  void releaseKey(int key);

  void moveMouseTo(Coordinate destination);

  void moveMouseBy(Coordinate cords);

  void waitCommand(int tim);

  void clickLeft();

  void clickRight();

  void clickScroll();

  void doubleClick();

  void scroll(int where);

  void hold(int tim);

  void drag(Coordinate where);

  Color getPixelColor(Coordinate cord);

  void errorNoise();

  Coordinate getPosition();

  void executeSystem(String command);

  void clickFast(long time_milliseconds, int button_mask);

  /**
   * Getter for variables, based on names.
   *
   * @param name name of wanted Variable.
   * @return Variable with given name.
   * @throws NoVariableWithThisNameException when Variable with this name does not exist in Environment.
   */
  Variable getVarByName(String name) throws NoVariableWithThisNameException;

  /**
   * Method used to check if Variable with given name exists in program.
   *
   * @param name Variable's name.
   * @return true if Variable with given name exists in program description.
   */
  boolean isThereVariable(String name);
}
