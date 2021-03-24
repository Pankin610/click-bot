package files.reading;

import program.Program;
import program.ProgramDescription;
import util.builders.ProgramBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

/**
 * First approximation of file-handling in this project.
 */

public final class ReadFileObject implements Iterable<String> {
    private final List<String> lineList;
    public ReadFileObject(String path) throws FileNotFoundException {
        try{
            lineList = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        }
        catch(IOException e){
            e.printStackTrace();
            throw new FileNotFoundException("There are problems with file:\n" + path);
        }
    }

    @Override
    public ListIterator<String> iterator() {
        return new ListIterator<>() {
            private final ListIterator<String> it = lineList.listIterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public String next() {
                return it.next();
            }

            @Override
            public boolean hasPrevious() {
                return it.hasPrevious();
            }

            @Override
            public String previous() {
                return it.previous();
            }

            @Override
            public int nextIndex() {
                return it.nextIndex();
            }

            @Override
            public int previousIndex() {
                return it.previousIndex();
            }

            @Override
            public void remove() {
                it.remove();
            }

            @Override
            public void set(String s) {
                it.set(s);
            }

            @Override
            public void add(String s) {
                it.add(s);
            }
        };
    }

    /**
     * Get line from attached file.
     * @param ind number of line.
     * @return line with given number.
     */
    public String getLine(int ind){
        return lineList.get(ind);
    }

    private void loadVariables(ListIterator<String> it, ProgramBuilder res){
        /* TODO: parse variables from file */
    }

    private void loadCommands(ListIterator<String> it, ProgramBuilder res){
        /* TODO: parse commands from file */
    }

    /**
     * Method parsing program from attached file.
     * @return program which corresponds to file content.
     */
    public Program getProgram(){
        ListIterator<String> it = lineList.listIterator();
        ProgramBuilder res = new ProgramBuilder();
        loadVariables(it,res);
        loadCommands(it,res);
        return new ProgramDescription(res);
    }
}
