package lang.commands;

import exceptions.NonImplementedMethodException;
import gui.applications.projecting.AddCommandWindow;
import gui.applications.projecting.AddVariableWindow;
import gui.controllers.AddCommandController;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditorSkin;
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
        public Command createCommand() {
            return Command.NOTHING;
        }
    },
    IF_CONDITION(new IfCondition(new Command[]{Command.NOTHING}, True.TRUE)),
    IF_ELSE(new IfElse(new Command[]{Command.NOTHING}, new Command[]{Command.NOTHING},True.TRUE)),
    REPEAT(new Repeat(new Command[]{Command.NOTHING},0)),
    WHILE(new While(new Command[]{Command.NOTHING},True.TRUE)),
    WAIT(new Wait(1000)){
        @Override
        public Command createCommand() {
            AddCommandController controller = AddCommandWindow.getController();
            controller.textFieldLabel.setText("Time in milliseconds");
            controller.textField.addEventFilter(KeyEvent.KEY_TYPED, keyEvent -> {
                if(!"0123456789".contains(keyEvent.getCharacter())) keyEvent.consume();
            });
            Stage stage = AddCommandWindow.getStage();
            stage.setTitle("Wait");
            stage.showAndWait();
            if(controller.successful_creation){
                controller.successful_creation = false;
                return new Wait(Integer.parseInt(controller.textField.getCharacters().toString()));
            }
            return null;
        }
    },
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

    /**
     * Method invoking after AddCommand button in project scene.
     * @return created Command or null when creation process was cancelled.
     */
    public Command createCommand(){
        System.out.println("Command::showWindow in " + this.name());
        return null;
    }
}
