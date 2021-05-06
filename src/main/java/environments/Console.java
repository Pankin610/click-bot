package environments;

import program.Program;
import util.Coordinate;

import java.awt.*;

/**
 * Class describing how program should behave in console environment.
 * Most methods associated with commands should be implemented in superclass.
 */

public final class Console extends AbstractEnvironment {
  public Console(Program program) {
    super(program);
  }

  /**
   * Fields handling simulation of normal desktop screen.
   */
  @Override
  public void holdKey(int key) {
    System.out.println("Holding key: " + key);
  }

  @Override
  public void releaseKey(int key) {
    System.out.println("Releasing key: " + key);
  }

  @Override
  public void pressKey(int key) {
    System.out.println("Pushing key: " + key);
  }

  @Override
  public void moveMouseTo(Coordinate destination) {
    myMouse.moveTo(destination);
    System.out.println("Moving mouse to:" + destination);
  }

  @Override
  public void moveMouseBy(Coordinate cords) {
    myMouse.moveBy(cords);
    System.out.println("Moving mouse by:" + cords);
  }

  @Override
  public void waitCommand(int tim) {
    System.out.println("I'm waiting " + tim + " time");
  }

  @Override
  public void clickLeft() {
    System.out.println("Clicking left");
  }

  @Override
  public void clickRight() {
    System.out.println("Clicking right");
  }

  @Override
  public void scroll(int where) {
    System.out.println("Scrolling in " + where + " direction");
  }

  @Override
  public void clickScroll() {
    System.out.println("Clicking scroll");
  }

  @Override
  public void doubleClick() {
    System.out.println("Double clicking");
  }

  @Override
  public void hold(int tim) {
    System.out.println("Holding for " + tim + " time");
  }

  @Override
  public void drag(Coordinate where) {
    System.out.println("Dragging to: " + where);
  } 
}
