package lang.commands.group;

import files.reading.ReadFileObject;
import lang.commands.Command;
import lang.variables.Variable;
import org.junit.Test;
import program.Program;

public class RepeatTest {
    @Test
    public void test1(){
        String path = "src/main/java/testing/testPrograms/loopProg.txt";
        Program program = Program.getProgramFromFile(new ReadFileObject(path));
        System.out.println(program.getName());
        for(Variable var : program.getVariables()){
            System.out.println(var.getStringRepresentation());
        }
        for(Command com : program.getCommands()) {
            System.out.println(com.getStringRepresentation());
        }
    }
}