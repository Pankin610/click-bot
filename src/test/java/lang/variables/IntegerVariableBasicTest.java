package lang.variables;

import exceptions.IncomparableVariablesException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerVariableBasicTest {
    private IntegerVariable var1,var2;
    @Before
    public void setUp() {
        var1 = new IntegerVariable("VarA",7);
        var2 = new IntegerVariable("VarB",9);
    }
    @Test
    public void getNameTest() {
        assertEquals("VarA",var1.getName());
        assertEquals("VarB",var2.getName());
    }

    @Test
    public void isLessThanTest() throws IncomparableVariablesException {
        assertTrue(var1.compareTo(var2) < 0);
        assertFalse(var2.compareTo(var1) < 0);
    }

    @Test
    public void getValueTest() {
        assertEquals(var1.getValue().intValue(),7);
        assertEquals(var2.getValue().intValue(),9);
        assertNotEquals(var1.getValue().intValue(),13);
    }

    @Test
    public void ArithmeticTest() throws IncomparableVariablesException {
        var1.add(2);
        assertNotEquals(var1.getValue().intValue(),7);
        assertEquals(var1.getValue(),var2.getValue());
        assertFalse(var1.compareTo(var2) < 0);
        assertFalse(var2.compareTo(var2) < 0);
        var1.increment();
        assertTrue(var2.compareTo(var1) < 0);
        var2.increment();
        assertEquals(var1.getValue(),var2.getValue());
        var1.decrement();
        var2.decrement();
        assertEquals(var1.getValue(),var2.getValue());
        var1.add(var2.getValue());
        assertEquals(var1.getValue().intValue(),18);
        var1.changeValue(14);
        assertEquals(var1.getValue().intValue(),14);
        var2.changeValue(var1.getValue());
        assertEquals(var1.getValue(),var2.getValue());
        var2.sub(var1.getValue());
        assertEquals(var2.getValue().intValue(),0);
    }
}