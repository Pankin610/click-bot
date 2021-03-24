package lang.variables;

import environments.Environment;
import util.Coordinate;

public class Mouse extends AbstractVariable {
    private Coordinate position;
    public Mouse(String m_name, Coordinate m_position) {
        super(m_name);
        position = m_position;
    }
    public Mouse(String m_name, int x_pos, int y_pos) {
        super(m_name);
        position = new Coordinate(x_pos,y_pos);
    }
    @Override
    public Coordinate getValue() {
        return position;
    }
    public Integer getColor(Environment envi){
        return envi.getPixel(position);
    }
    public void moveTo(Coordinate destination){
        position = destination;
    }
    public void moveTo(int x, int y){
        position = new Coordinate(x,y);
    }
    public void moveBy(int dx, int dy){
        position = new Coordinate(position.x+dx,position.y+dy);
    }
    public void moveBy(Coordinate vec){
        position = new Coordinate(position.x + vec.x, position.y + vec.y);
    }
}
