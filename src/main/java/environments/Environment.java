package environments;

import exceptions.ExecException;
import exceptions.NoVariableWithThisNameException;
import lang.variables.Variable;
import program.Program;
import util.Coordinate;

/**
 * This interface describes methods which implementation is necessary to make command calls correct.
 */
public interface Environment {
    void runProgram(Program program) throws ExecException;
    void pressKey(int key);
    void moveMouseTo(Coordinate destination);
    void moveMouseBy(Coordinate cords);
    void wait(int tim);
    void clickLeft();
    void clickRight();
    void scroll();
    void hold(int tim);
    void drag(Coordinate where);

    /**
     * Getter for variables, based on names.
     * @param name name of wanted Variable.
     * @return Variable with given name.
     * @throws NoVariableWithThisNameException when Variable with this name does not exist in Environment.
     */
    Variable getVarByName(String name) throws NoVariableWithThisNameException;

    /**
     * Method used to check if Variable with given name exists in program.
     * @param name Variable's name.
     * @return true if Variable with given name exists in program description.
     */
    boolean isThereVariable(String name);

    Integer getPixel(Coordinate cords);
    /* To be continued... */
}
