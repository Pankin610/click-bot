package util;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
  }
  public void typeLetter(char letter) {
    switch (letter) {
      case 'a': pressKey(KeyEvent.VK_A); break;
      case 'b': pressKey(KeyEvent.VK_B); break;
      case 'c': pressKey(KeyEvent.VK_C); break;
      case 'd': pressKey(KeyEvent.VK_D); break;
      case 'e': pressKey(KeyEvent.VK_E); break;
      case 'f': pressKey(KeyEvent.VK_F); break;
      case 'g': pressKey(KeyEvent.VK_G); break;
      case 'h': pressKey(KeyEvent.VK_H); break;
      case 'i': pressKey(KeyEvent.VK_I); break;
      case 'j': pressKey(KeyEvent.VK_J); break;
      case 'k': pressKey(KeyEvent.VK_K); break;
      case 'l': pressKey(KeyEvent.VK_L); break;
      case 'm': pressKey(KeyEvent.VK_M); break;
      case 'n': pressKey(KeyEvent.VK_N); break;
      case 'o': pressKey(KeyEvent.VK_O); break;
      case 'p': pressKey(KeyEvent.VK_P); break;
      case 'q': pressKey(KeyEvent.VK_Q); break;
      case 'r': pressKey(KeyEvent.VK_R); break;
      case 's': pressKey(KeyEvent.VK_S); break;
      case 't': pressKey(KeyEvent.VK_T); break;
      case 'u': pressKey(KeyEvent.VK_U); break;
      case 'v': pressKey(KeyEvent.VK_V); break;
      case 'w': pressKey(KeyEvent.VK_W); break;
      case 'x': pressKey(KeyEvent.VK_X); break;
      case 'y': pressKey(KeyEvent.VK_Y); break;
      case 'z': pressKey(KeyEvent.VK_Z); break;
      default:
        throw new IllegalArgumentException("Cannot type letter " + letter);
    }
  }
  public void typeText(String s) {
    for (int i = 0; i < s.length(); i++ ) {
      typeLetter(s.charAt(i));
    }
  }
}
