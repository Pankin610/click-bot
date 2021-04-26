package util.Bot;

import util.Coordinate;

import java.awt.*;
import java.awt.event.InputEvent;

public class Bot {
  Robot robot;
  final int kDefaultDelay = 100;
  public Bot() {
    try {
      robot = new Robot();
    }
    catch (AWTException exception) {
      System.out.println("Couldn't create bot.");
      exception.printStackTrace();
    }
  }
  public void wait(int wait_time) {
    robot.delay(wait_time);
  }
  public void moveMouse(int x, int y) {
    robot.mouseMove(x, y);
    robot.delay(kDefaultDelay);
  }
  void clickMouse(int mask) {
    robot.mousePress(mask);
    robot.mouseRelease(mask);
    robot.delay(kDefaultDelay);
  }
  public void leftClick() {
    clickMouse(InputEvent.BUTTON1_MASK);
  }
  public void rightClick() {
    clickMouse(InputEvent.BUTTON3_MASK);
  }
  public void scrollClick() {
    clickMouse(InputEvent.BUTTON2_MASK);
  }
  public void doubleClick() {
    leftClick();
    leftClick();
  }
  public void pressKey(int key_event_code) {
    robot.keyPress(key_event_code);
    robot.delay(kDefaultDelay);
    robot.keyRelease(key_event_code);
  }
  public void holdKey(int key_event_code) {
    robot.keyPress(key_event_code);
    robot.delay(kDefaultDelay);
  }
  public void releaseKey(int key_event_code) {
    robot.keyRelease(key_event_code);
    robot.delay(kDefaultDelay);
  }
  public Color getPixelColor(Coordinate cord) {
    return robot.getPixelColor(cord.x, cord.y);
  }
  public void delay(){
    robot.delay(kDefaultDelay);
  }
}
