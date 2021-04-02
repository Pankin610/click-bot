package files.reading;

import lang.CodeFactory;
import lang.commands.Command;
import lang.variables.Variable;
import org.junit.Test;
import program.Program;
import util.containers.VariableContainer;
import util.containers.VariableList;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ReadFileObjectTest {
    @Test
    public void test1() {
        Program program = new ReadFileObject("src/main/java/testing/testProg.txt").getProgram();
        System.out.println(program.getName());
        for(Variable var : program.getVariables()){
            System.out.println(var);
        }
        for(Command comm : program.getCommands()){
            System.out.println(comm);
        }
    }
    @Test
    public void test2() {
        Scanner cin = new ReadFileObject("src/main/java/testing/test.txt").getScanner();
        VariableContainer con = new VariableList();
        String[] res = new String[]{"my_int: 7", "var1: 10", "var2: 11"};
        for(int i=0;i<3;i++){
            con.add(CodeFactory.getVariableByID(cin.next()).parseFromString(cin));
        }
        Variable[] tmp = con.toArray();
        for(int i=0;i<3;i++){
            assertEquals(tmp[i].toString(),res[i]);
        }
    }
}