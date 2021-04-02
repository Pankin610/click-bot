package lang.variables;

import environments.Environment;
import exceptions.IncorrectVariableAssignment;
import util.Coordinate;

public final class Pixel extends AbstractVariable {
    private static final String id = "PIXEL";
    public Pixel(String m_name, int m_x, int m_y){
        super(m_name);
        cords = new Coordinate(m_x, m_y);
    }
    private Coordinate cords;

    /**
     * Getter for cords.
     * @return cords of Pixel.
     */
    @Override
    public Coordinate getValue() {
        return cords;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Pixel) {
            cords = ((Pixel)value).getValue();
        }
        if (value instanceof Mouse) {
            cords = ((Mouse)value).getValue();
        }
        if (value instanceof Coordinate) {
            cords = (Coordinate)value;
        }
        throw new IncorrectVariableAssignment(this, value);
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
