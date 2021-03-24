package lang.variables;

import environments.Environment;
import util.Coordinate;

public final class Pixel extends AbstractVariable {
    private static final String id = "PIXEL";
    public Pixel(String m_name, int m_x, int m_y){
        super(m_name);
        cords = new Coordinate(m_x,m_y);
    }
    private final Coordinate cords;

    /**
     * Getter for cords.
     * @return cords of Pixel.
     */
    @Override
    public Coordinate getValue() {
        return cords;
    }
    /**
     * Method shoving some sort of 'color' of given Pixel. Exact class responsible for handling colors will be implemented later.
     * Probably it will be variation of normal Integers.
     * @param envi environment in which command should be called.
     * @return returns color of given Pixel.
     */
    public Integer getColor(Environment envi){
        return envi.getPixel(cords);
    }

    @Override
    public String getId() {
        return id;
    }
}
