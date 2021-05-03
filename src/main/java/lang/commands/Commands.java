package lang.commands;

import exceptions.NonImplementedMethodException;
import javafx.stage.Stage;
import lang.commands.group.IfCondition;
import lang.commands.group.IfElse;
import lang.commands.group.Repeat;
import lang.commands.group.While;
import lang.commands.single.*;
import lang.conditions.True;
import util.Coordinate;

/**
 * Enum for all final implementation of Command interface.
 */
public enum Commands {
    NOTHING(Command.NOTHING){
        @Override
        public void showWindow(Stage owner) {
            System.out.println(getId());
        }
    },
    IF_CONDITION(new IfCondition(new Command[]{Command.NOTHING}, True.TRUE)),
    IF_ELSE(new IfElse(new Command[]{Command.NOTHING}, new Command[]{Command.NOTHING},True.TRUE)),
    REPEAT(new Repeat(new Command[]{Command.NOTHING},0)),
    WHILE(new While(new Command[]{Command.NOTHING},True.TRUE)),
    WAIT(new Wait(1000)),
    PRESS(new PressKey(0)),
    MAKE_SOME_NOISE(MakeSomeNoise.MAKE_SOME_NOISE),
    TYPE_COMMAND(new TypeCommand("")),
    RELEASE_KEYS_COMMAND(new ReleaseKeysCommand("")),
    MOVE_MOUSE(new MoveMouse(new Coordinate(0,0))),
    HOLD_KEYS_COMMAND(new HoldKeysCommand(""));

    private final Command comm;
    Commands(Command comm){
        this.comm = comm;
    }

    public Command get(){
        return comm;
    }
    public String getId(){return comm.getId();}
    public void showWindow(Stage owner){
        System.out.println(getId());
       // throw new NonImplementedMethodException("Command::showWindow in " + this.name());
    }
}
