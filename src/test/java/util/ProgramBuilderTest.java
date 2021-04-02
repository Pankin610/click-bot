package util;

import exceptions.NoUniqueVariableNameException;
import lang.CodeFactory;
import lang.commands.Command;
import lang.variables.IntegerVariable;
import lang.variables.VariableDescription;
import org.junit.Before;
import org.junit.Test;
import util.builders.ProgramBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ProgramBuilderTest {
    private ProgramBuilder tmp;
    private final IntegerVariable var1 = new IntegerVariable("var1",7);
    private final IntegerVariable var2 = new IntegerVariable("var2",13);

    @Before
    public void setUp() throws NoUniqueVariableNameException {
        tmp = new ProgramBuilder();
        tmp.addCommand(CodeFactory.NOTHING);
        tmp.addCommand(CodeFactory.IF_CONDITION);
        tmp.addVariable(new VariableDescription(var1));
    }

    @Test
    public void getCommands() {
        Command[] com = tmp.getCommands();
        assertSame(com[0],CodeFactory.NOTHING);
        assertSame(com[1],CodeFactory.IF_CONDITION);
    }

    @Test
    public void getVariables() {
        VariableDescription[] var = tmp.getVariablesDescription();
        assertSame(var[0].getVariable().getValue(),var1.getValue());
    }

    @Test
    public void addVariable() throws NoUniqueVariableNameException {
        tmp.addVariable(new VariableDescription(var2));
        VariableDescription[] var = tmp.getVariablesDescription();
        assertEquals(var[0].getVariable().getValue(),var1.getValue());
        assertEquals(var[1].getVariable().getValue(),var2.getValue());
    }

    @Test(expected = NoUniqueVariableNameException.class)
    public void uniqueTest() throws NoUniqueVariableNameException {
        tmp.addVariable(new VariableDescription(var1));
    }

    @Test
    public void addCommand() {
        tmp.addCommand(CodeFactory.WHILE);
        tmp.addCommand(CodeFactory.NOTHING);
        Command[] com = tmp.getCommands();
        assertSame(com[0],CodeFactory.NOTHING);
        assertSame(com[1],CodeFactory.IF_CONDITION);
        assertSame(com[2],CodeFactory.WHILE);
        assertSame(com[3],CodeFactory.NOTHING);
    }

    @Test
    public void viewVariables() throws NoUniqueVariableNameException {
        tmp.viewVariablesId();
        tmp.addVariable(new VariableDescription(var2));
        tmp.viewVariablesId();
    }

    @Test
    public void viewCommands() {
        tmp.viewCommandsId();
        tmp.addCommand(CodeFactory.WHILE);
        tmp.addCommand(CodeFactory.NOTHING);
        tmp.viewCommandsId();
    }
}