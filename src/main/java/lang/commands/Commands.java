package lang.commands;

import gui.WindowsManager;
import gui.applications.projecting.AddCommandWindow;
import gui.controllers.AddCommandController;
import javafx.scene.input.KeyEvent;
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
    REPEAT(new Repeat(new Command[]{Command.NOTHING},0)){
        @Override
        public Command createCommand() {
            AddCommandController controller = AddCommandWindow.getController();
            controller.reload();
            controller.textFieldLabel.setText("Number of repetitions");
            controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
            Stage stage = AddCommandWindow.getStage();
            stage.setTitle("Repeat");
            stage.showAndWait();
            Command res = null;
            if(controller.successful_creation)
                res = new Repeat(new Command[]{Command.NOTHING},
                        Integer.parseInt(controller.textField.getCharacters().toString()));
            return res;
        }
    },
    WHILE(new While(new Command[]{Command.NOTHING},True.TRUE)),
    WAIT(new Wait(1000)){
        @Override
        public Command createCommand() {
            AddCommandController controller = AddCommandWindow.getController();
            controller.reload();
            controller.textFieldLabel.setText("Time in milliseconds");
            controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
            Stage stage = AddCommandWindow.getStage();
            stage.setTitle("Wait");
            stage.showAndWait();
            Command res = null;
            if(controller.successful_creation)
                res = new Wait(Integer.parseInt(controller.textField.getCharacters().toString()));
            return res;
        }
    },
    PRESS(new PressKey(0)){
        @Override
        public Command createCommand() {
            AddCommandController controller = AddCommandWindow.getController();
            controller.reload();
            Stage stage = AddCommandWindow.getStage();
            stage.setTitle("Press key");
            controller.textFieldLabel.setText("Key code");
            controller.textField.addEventFilter(KeyEvent.KEY_PRESSED, AddCommandWindow.codeOfKey);
            controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.consumeTyped);
            stage.showAndWait();
            Command res = null;
            if(controller.successful_creation)
                res = new PressKey(Integer.parseInt(controller.textField.getCharacters().toString()));
            return res;
        }
    },
    MAKE_SOME_NOISE(MakeSomeNoise.MAKE_SOME_NOISE){
        @Override
        public Command createCommand() {
            return MakeSomeNoise.MAKE_SOME_NOISE;
        }
    },
    TYPE_COMMAND(new TypeCommand("")),
    RELEASE_KEYS_COMMAND(new ReleaseKeysCommand("")),
    MOVE_MOUSE(new MoveMouse(new Coordinate(0,0))){
        @Override
        public Command createCommand() {
            AddCommandController controller = AddCommandWindow.getController();
            controller.reload();
            Stage stage = AddCommandWindow.getStage();
            stage.setTitle("Move mouse");
            controller.textFieldLabel.setText("Coordinates");
            controller.utilityButton.setVisible(true);
            controller.utilityButton.setText("Get cords");
            controller.utilityButton.setOnAction(actionEvent ->
                    controller.textField.setText(WindowsManager.getCords().toString()));
            stage.showAndWait();
            Command res = null;
            if(controller.successful_creation){
                String[] tab = controller.textField.getCharacters().toString().split(" ");
                res = new MoveMouse(new Coordinate(Integer.parseInt(tab[0]), Integer.parseInt(tab[1])));
            }
            return res;
        }
    },
    HOLD_KEYS_COMMAND(new HoldKeysCommand("")),
    EXECUTE_COMMAND(new ExecuteCommand("")),
    SCROLL_DOWN_COMMAND(new ScrollCommand(0)),
    SCROLL_UP_COMMAND(new ScrollUpCommand(0)),
    SCROLL_COMMAND(new ScrollCommand(0)),
    DRAG(new DragCommand(new Coordinate(0, 0))),
    DOUBLE_CLICK(new DoubleClickCommand()),
    MOUSE_LEFT_CLICK(MouseLeftClick.MOUSE_LEFT_CLICK){
        @Override
        public Command createCommand() {
            return MouseLeftClick.MOUSE_LEFT_CLICK;
        }
    },
    MOUSE_RIGHT_CLICK(MouseRightClick.MOUSE_RIGHT_CLICK){
        @Override
        public Command createCommand() {
            return MouseRightClick.MOUSE_RIGHT_CLICK;
        }
    },
    MOUSE_SCROLL_CLICK(MouseScrollClick.MOUSE_SCROLL_CLICK){
        @Override
        public Command createCommand() {
            return MouseScrollClick.MOUSE_SCROLL_CLICK;
        }
    };

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
     * Later this may be moved to Command interface.
     * @return created Command or null when creation process was cancelled.
     */
    public Command createCommand(){
        System.out.println("Commands::createCommand in " + this.name() + " is not implemented");
        return null;
    }
}
