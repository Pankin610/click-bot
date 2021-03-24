package files.writing;

import lang.commands.Command;
import lang.variables.Variable;
import program.Program;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Same as ReadFileObject, it is first approximation of file-handling in this project.
 */
public final class WriteFileObject {
    private final String path;
    private FileOutputStream file;
    public WriteFileObject(String m_path){
        path = m_path;
    }
    /**
     * Save program's description to given file.
     * @param program program to be saved
     * @throws FileNotFoundException when something with given file gone wrong.
     */
    public void saveToFile(Program program) throws FileNotFoundException {
        try{
            file = new FileOutputStream(path);
            saveProgramToFile(program);
            file.close();
        } catch (IOException e){
            e.printStackTrace();
            throw new FileNotFoundException("There are problems with file:\n" + path);
        }
    }

    private void writeVariables(Program program) throws IOException {
        for(Variable var : program.getVariables()){
            String rep = var.getStringRepresentation();
            file.write(rep.getBytes(),0,rep.length());
        }
    }

    private void writeCommands(Program program) throws IOException {
        for(Command com : program.getCommands()){
            String rep = com.getStringRepresentation();
            file.write(rep.getBytes(),0,rep.length());
        }
    }

    private void saveProgramToFile(Program program) throws IOException {
        /* TODO: preamble for variables */
        writeVariables(program);
        /* TODO: preamble for commands */
        writeCommands(program);
    }

}
