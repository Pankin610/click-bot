package files.writing;

import lang.commands.Command;
import lang.variables.Variable;
import program.Program;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Same as ReadFileObject, it is first approximation of file-handling in this project.
 */
public final class WriteFileObject {
  private final String path;
  private FileOutputStream file;

  public WriteFileObject(String path) {
    this.path = path;
  }

  /**
   * Save program's description to given file.
   *
   * @param program program to be saved
   * @throws FileNotFoundException when something with given file gone wrong.
   */
  public void saveToFile(Program program) throws IOException {
    try {
      file = new FileOutputStream(path);
      saveProgramToFile(program);
    } finally {
      file.close();
    }
  }

  private void writeVariables(Program program) throws IOException {
    file.write(("VARIABLES " + program.getNumOfVariables() + "\n").getBytes(StandardCharsets.UTF_8));
    for (Variable var : program.getVariables()) {
      file.write(var.getStringRepresentation().getBytes(StandardCharsets.UTF_8));
      file.write('\n');
    }
  }

  private void writeCommands(Program program) throws IOException {
    file.write(("COMMANDS\n").getBytes(StandardCharsets.UTF_8));
    for (Command com : program.getCommands()) {
      file.write(com.getStringRepresentation().getBytes(StandardCharsets.UTF_8));
      file.write('\n');
    }
  }

  private void saveProgramToFile(Program program) throws IOException {
    file.write(("PROGRAM " + program.getName() + "\n").getBytes(StandardCharsets.UTF_8));
    writeVariables(program);
    writeCommands(program);
  }

}
