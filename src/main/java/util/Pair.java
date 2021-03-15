package util;

/**
 * Class used to describe mouse and pixel position on screen
 */

public class Pair {
    public int x,y;
    public Pair(){x=0;y=0;}
    public Pair(int m_x, int m_y){x=m_x;y=m_y;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }
}
