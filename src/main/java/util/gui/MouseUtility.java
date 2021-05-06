package util.gui;

import util.Bot.Bot;
import util.Coordinate;

import java.awt.*;

public class MouseUtility {
    public static Coordinate getCords(){
        return new Coordinate(MouseInfo.getPointerInfo().getLocation());
    }
    public static Color getColor(){
        return new Bot().getPixelColor(getCords());
    }
}
