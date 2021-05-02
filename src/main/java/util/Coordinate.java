package util;

import java.awt.*;

/**
 * Class used to describe mouse and pixel position on screen
 */

public final class Coordinate {
    public int x, y;
    public Coordinate(){
        this(0,0);
    }
    //TODO checking if the screen coordinate is valid - it should be implemented in specific environment
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate)o;
        return x == other.x && y == other.y;
    }
    @Override
    public String toString() {
        return String.valueOf(x) + ' ' + y;
    }
}
