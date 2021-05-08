package environments;

import program.Program;
import util.Coordinate;
import util.bot.Bot;

import java.awt.*;
import java.io.IOException;

/**
 * Environment in which Bot implementation of Commands is used.
 */

public final class DesktopEnvironment extends AbstractEnvironment {
  private final Bot bot;

  public DesktopEnvironment(Program program) {
    super(program);
    this.bot = new Bot();
  }

  @Override
  public void pressKey(int key) {
    bot.pressKey(key);
  }

  @Override
  public void holdKey(int key) {
    bot.holdKey(key);
  }

  @Override
  public void releaseKey(int key) {
    bot.releaseKey(key);
  }

  @Override
  public void moveMouseTo(Coordinate destination) {
    myMouse.moveTo(destination);
    bot.moveMouse(destination.x, destination.y);
  }

  @Override
  public void moveMouseBy(Coordinate cords) {
    super.moveMouseBy(cords);
  }

  @Override
  public void waitCommand(int tim) {
    bot.wait(tim);
  }

  @Override
  public void clickLeft() {
    bot.leftClick();
  }

  @Override
  public void clickRight() {
    bot.rightClick();
  }

  @Override
  public void doubleClick() {
    bot.doubleClick();
  }

  @Override
  public void clickScroll() {
    bot.scrollClick();
  }

  @Override
  public void scroll(int where) {
    bot.scroll(where);
  }

  @Override
  public void hold(int tim) {
    super.hold(tim);
  }

  @Override
  public void drag(Coordinate where) {
    bot.drag(where);
  }

  @Override
  public Color getPixelColor(Coordinate cords) {
    return bot.getPixelColor(cords);
  }

  @Override
  public void errorNoise() {
    bot.beep();
  }

  @Override
  public Coordinate getPosition() {
    Point pnt = MouseInfo.getPointerInfo().getLocation();
    return new Coordinate(pnt);
  }

  @Override
  public void runProgram() {
    for (int i = 5; i >= 1; i--) {
      System.out.println("Running in " + i + "...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    super.runProgram();
  }

  @SuppressWarnings("all")
  public static void main(String[] args) throws AWTException, IOException {
    Robot robot = new Robot();
    for (int i = 0; i < 10; i++) {
      System.in.read();
      Coordinate cord = new Coordinate(MouseInfo.getPointerInfo().getLocation());
      System.out.println(robot.getPixelColor(cord.x, cord.y).getRGB());
    }
  }
}
