package util.bot;

import gui.Settings;
import util.Coordinate;

import java.awt.*;
import java.awt.event.InputEvent;

public class Bot {
  Robot robot;
  final int kDefaultDelay = Settings.getDelay();

  public Bot() {
    try {
      robot = new Robot();
    } catch (AWTException exception) {
      System.out.println("Couldn't create bot.");
      exception.printStackTrace();
    }
  }

  public void wait(int wait_time) {
    robot.delay(wait_time);
  }

  public void moveMouse(int x, int y) {
    robot.mouseMove(x, y);
    smallDelay();
  }

  void clickMouse(int mask) {
    robot.mousePress(mask);
    robot.mouseRelease(mask);
    smallDelay();
  }

  public void leftClick() {
    clickMouse(InputEvent.BUTTON1_DOWN_MASK);
  }

  public void rightClick() {
    clickMouse(InputEvent.BUTTON3_DOWN_MASK);
  }

  public void scrollClick() {
    clickMouse(InputEvent.BUTTON2_DOWN_MASK);
  }

  public void doubleClick() {
    leftClick();
    leftClick();
  }

  // parameter 'where' - how many times to scroll the mouse
  // negative number - scrolls upwards, positive - downwards
  public void scroll(int where) {
    robot.mouseWheel(where);
    smallDelay();
  }

  // simple drag from current location to the given one
  public void drag(Coordinate where) {
    Coordinate p = new Coordinate(MouseInfo.getPointerInfo().getLocation());
    int C = 30; //number of iterations
    Coordinate dv = new Coordinate((where.x - p.x)/C, (where.y-p.y)/C);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    try {
        for (int t = C; t > 0; t--) {
          p.x += dv.x;
          p.y += dv.y;
          robot.mouseMove(p.x, p.y);
          Thread.sleep(5);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
  }

  public void pressKey(int key_event_code) {
    robot.keyPress(key_event_code);
    smallDelay();
    robot.keyRelease(key_event_code);
  }

  public void holdKey(int key_event_code) {
    robot.keyPress(key_event_code);
    smallDelay();
  }

  public void releaseKey(int key_event_code) {
    robot.keyRelease(key_event_code);
    smallDelay();
  }

  public Color getPixelColor(Coordinate cord) {
    return robot.getPixelColor(cord.x, cord.y);
  }

  public void smallDelay() {
    robot.delay(kDefaultDelay);
  }
  public void bigDelay() {
    robot.delay(1000);
  }

  public void beep() {
    Toolkit.getDefaultToolkit().beep();
    robot.delay(kDefaultDelay);
  }
}
