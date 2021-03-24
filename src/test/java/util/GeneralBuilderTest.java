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
    public void setUp(){
        tmp = new GeneralBuilder<>(Command.class,Command[].class);
        tmp.append(CodeFactory.NOTHING);
        tmp.append(CodeFactory.IF_CONDITION);
    }
    
    @Test
    public void forEach() {
        for(Command com : tmp){
            assertTrue(com == CodeFactory.NOTHING || com == CodeFactory.IF_CONDITION);
        }
    }

    @Test
    public void toArray() {
        Command[] com = tmp.toArray();
        assertSame(com[0],CodeFactory.NOTHING);
        assertSame(com[1],CodeFactory.IF_CONDITION);
    }

    @Test
    public void append() {
        tmp.append(CodeFactory.NOTHING);
        tmp.append(CodeFactory.NOTHING);
        Command[] com = tmp.toArray();
        assertSame(com[0],CodeFactory.NOTHING);
        assertSame(com[1],CodeFactory.IF_CONDITION);
        assertSame(com[2],CodeFactory.NOTHING);
        assertSame(com[3],CodeFactory.NOTHING);
    }

    @Test
    public void size() {
        assertEquals(tmp.size(),2);
        tmp.append(CodeFactory.NOTHING);
        tmp.append(CodeFactory.NOTHING);
        assertEquals(tmp.size(),4);
    }
}