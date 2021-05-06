package util;

import lang.CodeFactory;
import lang.commands.Command;
import org.junit.Before;
import org.junit.Test;
import util.builders.Builder;
import util.builders.GeneralBuilder;

import static org.junit.Assert.*;

public class GeneralBuilderTest {
  private Builder<Command> tmp;

  @Before
  public void setUp() {
    tmp = new GeneralBuilder<>(Command.class, Command[].class);
    tmp.append(CodeFactory.getCommandByID("NOTHING"));
    tmp.append(CodeFactory.getCommandByID("IF_CONDITION"));
  }

  @Test
  public void forEach() {
    for (Command com : tmp) {
      assertTrue(com == CodeFactory.getCommandByID("NOTHING") || com == CodeFactory.getCommandByID("IF_CONDITION"));
    }
  }

  @Test
  public void toArray() {
    Command[] com = tmp.toArray();
    assertSame(com[0], CodeFactory.getCommandByID("NOTHING"));
    assertSame(com[1], CodeFactory.getCommandByID("IF_CONDITION"));
  }

  @Test
  public void append() {
    tmp.append(CodeFactory.getCommandByID("NOTHING"));
    tmp.append(CodeFactory.getCommandByID("NOTHING"));
    Command[] com = tmp.toArray();
    assertSame(com[0], CodeFactory.getCommandByID("NOTHING"));
    assertSame(com[1], CodeFactory.getCommandByID("IF_CONDITION"));
    assertSame(com[2], CodeFactory.getCommandByID("NOTHING"));
    assertSame(com[3], CodeFactory.getCommandByID("NOTHING"));
  }

  @Test
  public void size() {
    assertEquals(tmp.size(), 2);
    tmp.append(CodeFactory.getCommandByID("NOTHING"));
    tmp.append(CodeFactory.getCommandByID("NOTHING"));
    assertEquals(tmp.size(), 4);
  }
}