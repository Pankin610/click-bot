package environments;

import lang.variables.Variable;
import program.Program;
import util.Coordinate;

/**
 * Class describing how program should behave in console environment.
 * Most methods associated with commands should be implemented in superclass.
 */

public final class Console extends AbstractEnvironment {
    public Console(Program program) {
        super(program);
        PixelArray = new Integer[x_size][y_size];
    }

    /**
     * Fields handling simulation of normal desktop screen.
     */
    private Integer[][] PixelArray;
    private static final int x_size = 10;
    private static final int y_size = 10;
    public static boolean checkCords(Coordinate cords) {
        return cords.x < 0 || cords.x >= x_size || cords.y < 0 || cords.y >= y_size;
    }

    @Override
    public Integer getPixel(Coordinate cords) {
        if(checkCords(cords))  throw new IndexOutOfBoundsException();
        return PixelArray[cords.x][cords.y];
    }

    /**
     * 'Changing' color of given Pixel.
     * @param cords cords of Pixel in array.
     * @param val target value.
     */
    public void changeColor(Coordinate cords, Integer val) {
        if(checkCords(cords))  throw new IndexOutOfBoundsException();
        PixelArray[cords.x][cords.y] = val;
    }
}
