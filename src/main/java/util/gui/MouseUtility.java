package util.gui;

import util.Coordinate;
import util.bot.Bot;

import java.awt.*;

public class MouseUtility {
  public static Coordinate getCords() {
    return new Coordinate(MouseInfo.getPointerInfo().getLocation());
  }

  public static Color getColor() {
    return new Bot().getPixelColor(getCords());
  }
}
