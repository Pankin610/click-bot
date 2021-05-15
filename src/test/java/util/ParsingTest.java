package util;

import lang.variables.IntegerVariable;
import lang.variables.Variable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParsingTest {
  @Test
  public void basic() {
    assertEquals(Parsing.parseLiteral("var"), "'var'");

    Variable var = new IntegerVariable("daBaby", 1);
    assertEquals(Parsing.parseLiteral(var), "daBaby");

    assertEquals(Parsing.parseLiteral(5), "5");
  }
}
