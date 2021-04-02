package lang;

import lang.variables.IntegerVariable;
import lang.variables.Variable;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodeFactoryTest {
    @Test
    public void getInstanceByID() {
        assertEquals("WHILE",CodeFactory.getCommandByID("WHILE").getId());
        assertEquals("LESS_EQ",CodeFactory.getConditionByID("LESS_EQ").getId());
        Variable var = new IntegerVariable("var",7);
        assertEquals(var.getId(),CodeFactory.getVariableByID(var.getId()).getId());
    }
}