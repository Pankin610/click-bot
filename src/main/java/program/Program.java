package program;

import files.writing.WriteFileObject;
import lang.commands.Command;
import lang.commands.Executable;
import lang.variables.Variable;

import java.io.FileNotFoundException;

public interface Program extends Executable {
    Variable[] getVariables();
    Command[] getCommands();
    String getName();
    /**
     * Method saving program to given file.
     * @param file where program should be saved.
     * @throws FileNotFoundException when there are problems with given file.
     */
    void saveToFile(WriteFileObject file) throws FileNotFoundException;
}
