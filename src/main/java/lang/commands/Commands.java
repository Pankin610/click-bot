package lang.commands;

import lang.commands.group.IfCondition;
import lang.commands.group.IfElse;
import lang.commands.group.Repeat;
import lang.commands.group.While;
import lang.commands.single.Wait;
import lang.conditions.True;

/**
 * Enum for all final implementation of Command interface.
 */
public enum Commands {
    NOTHING(Command.NOTHING),
    IF_CONDITION(new IfCondition(new Command[]{Command.NOTHING}, True.TRUE)),
    IF_ELSE(new IfElse(new Command[]{Command.NOTHING}, new Command[]{Command.NOTHING},True.TRUE)),
    REPEAT(new Repeat(new Command[]{Command.NOTHING},0)),
    WHILE(new While(new Command[]{Command.NOTHING},True.TRUE)),
    WAIT(new Wait(1000));

    private final Command comm;
    Commands(Command comm){
        this.comm = comm;
    }

    public Command get(){
        return comm;
    }
}
