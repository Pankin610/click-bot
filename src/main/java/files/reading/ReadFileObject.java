package files.reading;

import exceptions.WrongFileFormatException;
import lang.CodeFactory;
import lang.variables.VariableDescription;
import program.Program;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * First approximation of file-handling in this project.
 */

public final class ReadFileObject {
  private Scanner scanner; /* maybe later final */
  private final String path;

  /**
   * @param path to file with description starting from 'src' file.
   */
  public ReadFileObject(String path) {
    this.path = path;
    scanner = null;
    try {
      scanner = new Scanner(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return Scanner inside this object - be careful, as it changes its state
   * (probably useless, but may be handful for testing).
   */
  public Scanner getScanner() {
    return scanner;
  }

  /**
   * Can be used to restart scanner inside this object
   * (probably useless, but may be handful for testing).
   */
  public void reload() {
    scanner = null;
    try {
      scanner = new Scanner(new File(path));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method parsing program from attached file.
   *
   * @return program which corresponds to file content.
   */
  public Program getProgram() {
    return new ProgramDescription(this);
  }
}
