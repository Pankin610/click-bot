package program;

import files.reading.ReadFileObject;
import files.writing.WriteFileObject;
import lang.commands.Command;
import lang.variables.Variable;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Program {
  Variable[] getVariables();

  int getNumOfVariables();

  Command[] getCommands();

  int getNumOfCommands();

  String getName();

  /**
   * Method saving program to given file.
   *
   * @param file where program should be saved.
   * @throws FileNotFoundException when there are problems with given file.
   */
  void saveToFile(WriteFileObject file) throws IOException;

  static Program getProgramFromFile(ReadFileObject file) {
    return new ProgramDescription(file);
  }

  /**
   * Method showing content of Program: name, variables and commands.
   */
  default void show() {
    System.out.println(getName());
    for (Variable var : getVariables()) {
      System.out.println(var.getStringRepresentation());
    }
    for (Command com : getCommands()) {
      System.out.println(com.getStringRepresentation());
    }
  }
}
