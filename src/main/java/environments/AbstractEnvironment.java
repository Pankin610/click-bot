package environments;

import exceptions.ExecException;
import exceptions.NoVariableWithThisNameException;
import lang.commands.Command;
import lang.variables.Mouse;
import lang.variables.Variable;
import program.Program;
import util.Coordinate;
import util.containers.VariableContainer;
import util.containers.VariableList;

import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.io.IOException;

/**
 * Abstract environment contains default (Console) implementation of methods associated with instances of Command interface,
 * such as PushButton, Move, Hold, etc...
 */
public abstract class AbstractEnvironment implements Environment {
  protected final VariableContainer variables = new VariableList();
  protected Mouse myMouse = new Mouse("Mouse", 0, 0);
  protected final Program program;

  protected AbstractEnvironment(Program program) {
    this.program = program;
    variables.addAll(program.getVariables());
  }

  @Override
  public void runProgram() throws ExecException {
    //TODO make this inside new Thread (endgame)
    for (Command com : program.getCommands()) {
      com.execute(this);
    }
  }

  @Override
  public void holdKey(int key) {
    throw new UnsupportedOperationException("This environment doesn't support holding a key.");
  }

  @Override
  public void releaseKey(int key) {
    throw new UnsupportedOperationException("This environment doesn't support releasing a key.");
  }

  @Override
  public void pressKey(int key) {
    throw new UnsupportedOperationException("This environment doesn't support pressing a key.");
  }

  @Override
  public void moveMouseTo(Coordinate destination) {
    throw new UnsupportedOperationException("This environment doesn't support moving mouse to some destination.");
  }

  @Override
  public void moveMouseBy(Coordinate cords) {
    throw new UnsupportedOperationException("This environment doesn't support moving mouse by some coordinate.");
  }

  @Override
  public void waitCommand(int tim) {
    throw new UnsupportedOperationException("This environment doesn't support waiting.");
  }

  @Override
  public void clickLeft() {
    throw new UnsupportedOperationException("This environment doesn't support left click.");
  }

  @Override
  public void clickRight() {
    throw new UnsupportedOperationException("This environment doesn't support right click.");
  }

  @Override
  public void scroll(int where) {
    throw new UnsupportedOperationException("This environment doesn't support scrolling.");
  }

  @Override
  public void clickScroll() {
    throw new UnsupportedOperationException("This environment doesn't support scroll click.");
  }

  @Override
  public void doubleClick() {
    throw new UnsupportedOperationException("This environment doesn't support double click.");
  }

  @Override
  public void hold(int tim) {
    throw new UnsupportedOperationException("This environment doesn't support holding.");
  }

  @Override
  public void drag(Coordinate where) {
    throw new UnsupportedOperationException("This environment doesn't support dragging.");
  }

  @Override
  public void clickFast(long time_milliseconds, int button_mask) {
    throw new UnsupportedOperationException("This environment doesn't support fast clicking");
  }

  @Override
  public Variable getVarByName(String name) throws NoVariableWithThisNameException {
    for (Variable var : variables) if (var.getName().equals(name)) return var;
    throw new NoVariableWithThisNameException(name);
  }

  @Override
  public boolean isThereVariable(String varName) {
    for (Variable var : variables) if (varName.equals(var.getName())) return true;
    return false;
  }

  @Override
  public Color getPixelColor(Coordinate cords) {
    return new Color(0x000000);
  }

  @Override
  public Coordinate getPosition() {
    return new Coordinate(0, 0);
  }

  @Override
  public void executeSystem(String command) { //TODO make this work on Windows
    System.out.println(command);
    try {
      Process process = Runtime.getRuntime().exec(command);
      process.waitFor();
    } catch (IOException | InterruptedException e) {
      throw new ExecException("An IOException occurred.", e);
    }
  }

  @Override
  public void errorNoise() {
    System.out.println("beep");
  }
}
