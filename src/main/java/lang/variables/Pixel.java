package lang.variables;

import environments.Environment;
import exceptions.IncorrectVariableAssignment;
import util.Coordinate;

import java.awt.*;
import java.util.Scanner;

public final class Pixel extends AbstractVariable {
  private static final String id = "PIXEL";
  private Coordinate cords;

  public Pixel(String name, int x, int y) {
    super(name);
    this.cords = new Coordinate(x, y);
  }

  public Pixel(String name, Coordinate cords) {
    this(name, cords.x, cords.y);
  }

  /**
   * Getter for cords.
   *
   * @return cords of Pixel.
   */
  @Override
  public Coordinate getValue() {
    return cords;
  }

  /**
   * Method shoving some sort of 'color' of given Pixel.
   * Exact class responsible for handling colors will be implemented later.
   * Probably it will be variation of normal Integers.
   *
   * @param environment environment in which command should be called.
   * @return returns color of given Pixel.
   */
  public Color getColor(Environment environment) {
    return environment.getPixelColor(cords);
  }

  @Override
  public void setValue(Object value) {
    if (value instanceof Pixel) {
      cords = ((Pixel) value).getValue();
    }
    if (value instanceof Mouse) {
      cords = ((Mouse) value).getValue();
    }
    if (value instanceof Coordinate) {
      cords = (Coordinate) value;
    }
    throw new IncorrectVariableAssignment(this, value);
  }

  @Override
  public String getId() {
    return id;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Variable parseFromString(Scanner scanner) {
    String name = scanner.next();
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    return new Pixel(name, new Coordinate(x, y));
  }
}
