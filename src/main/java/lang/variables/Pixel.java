package lang.variables;

import util.Pair;

public class Pixel implements Variable {
    Pixel(int m_x, int m_y){
        cords = new Pair(m_x,m_y);
    }
    public final Pair cords;
    public Object getColor(){return new Object();}
}
