package lang.commands;

import gui.applications.projecting.AddCommandWindow;
import gui.controllers.AddCommandController;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lang.CodeFactory;
import lang.commands.group.IfCondition;
import lang.commands.group.Repeat;
import lang.commands.group.While;
import lang.commands.single.*;
import lang.commands.single.variables.AddCommand;
import lang.commands.single.variables.SetCommand;
import lang.conditions.True;
import util.Coordinate;

/**
 * Enum for all final implementation of Command interface.
 */
public enum Commands {
  NOTHING(Command.NOTHING) {
    @Override
    public Command createCommand() {
      return Command.NOTHING;
    }
  },
  IF_CONDITION(new IfCondition(new Command[]{Command.NOTHING}, True.TRUE)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      controller.textField.setPrefWidth(400);
      controller.textFieldLabel.setText("Condition");
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("If");
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new IfCondition(new Command[]{Command.NOTHING},
                CodeFactory.parseCondition(controller.textField.getText()
                        .replace('(',' ').replace(')',' ')));
      }
      controller.textField.setPrefWidth(70);
      return res;
    }
  },
  REPEAT(new Repeat(new Command[]{Command.NOTHING}, 0)) {
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
      if (controller.successful_creation)
        res = new Repeat(new Command[]{Command.NOTHING},
                Integer.parseInt(controller.textField.getText()));
      return res;
    }
  },
  WHILE(new While(new Command[]{Command.NOTHING}, True.TRUE)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      controller.textField.setPrefWidth(400);
      controller.textFieldLabel.setText("Condition");
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("While");
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new While(new Command[]{Command.NOTHING},
                CodeFactory.parseCondition(controller.textField.getText()
                        .replace('(',' ').replace(')',' ')));
      }
      controller.textField.setPrefWidth(70);
      return res;
    }
  },
  WAIT(new Wait(1000)) {
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
      if (controller.successful_creation)
        res = new Wait(Integer.parseInt(controller.textField.getText()));
      return res;
    }
  },
  PRESS(new PressKey(0)) {
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
      if (controller.successful_creation)
        res = new PressKey(Integer.parseInt(controller.textField.getText()));
      return res;
    }
  },
  MAKE_SOME_NOISE(MakeSomeNoise.MAKE_SOME_NOISE) {
    @Override
    public Command createCommand() {
      return MakeSomeNoise.MAKE_SOME_NOISE;
    }
  },
  TYPE_COMMAND(new TypeCommand("")) {
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Type");
      controller.textFieldLabel.setText("Text to type");
      controller.textArea.setVisible(true);
      controller.textField.setVisible(false);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        System.out.println(controller.textArea.getText().charAt(controller.textArea.getText().length()-1));
        StringBuilder builder = new StringBuilder();
        String text = controller.textArea.getText();
        for(int i=0;i<text.length();i++){
          char t = text.charAt(i);
          if(t=='\n'){
            builder.append("ENTER");
          } else if('A' <= t && t <= 'Z'){
            builder.append("CAPS_LOCK").append((char)(t - 'A' + 'a')).append("CAPS_LOCK");
          } else builder.append(t);
        }
        res = new TypeCommand(builder.toString());
      }
      controller.textField.setVisible(true);
      return res;
    }
  },
//  RELEASE_KEYS_COMMAND(new ReleaseKeysCommand("")),
  MOVE_MOUSE(new MoveMouse(new Coordinate(0, 0))) {
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Move mouse");
      controller.textFieldLabel.setText("Coordinates");
      controller.textField.setPromptText("Click q");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.cords);
      stage.showAndWait();
      Command res = null;
      if (controller.successful_creation) {
        String[] tab = controller.textField.getCharacters().toString().split(" ");
        res = new MoveMouse(new Coordinate(Integer.parseInt(tab[0]), Integer.parseInt(tab[1])));
      }

      return res;
    }
  },
//  HOLD_KEYS_COMMAND(new HoldKeysCommand("")),
  EXECUTE_COMMAND(new ExecuteCommand("")){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Execute");
      controller.textFieldLabel.setText("Command to execute");
      controller.textField.setPrefWidth(300);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new ExecuteCommand(controller.textField.getText());
      }
      controller.textField.setPrefWidth(70);
      return res;
    }
  },
  SCROLL_DOWN_COMMAND(new ScrollDownCommand(0)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Scroll down");
      controller.textFieldLabel.setText("How much?");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new ScrollDownCommand(Integer.parseInt(controller.textField.getText()));
      }
      return res;
    }
  },
  SCROLL_UP_COMMAND(new ScrollUpCommand(0)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Scroll up");
      controller.textFieldLabel.setText("How much?");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new ScrollUpCommand(Integer.parseInt(controller.textField.getText()));
      }
      return res;
    }
  },
//  SCROLL_COMMAND(new ScrollCommand(0)),
  DRAG(new DragCommand(new Coordinate(0, 0))){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Drag");
      controller.textFieldLabel.setText("Where");
      controller.textField.setPromptText("Click q");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.cords);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        String[] tab = controller.textField.getText().split(" ");
        res = new DragCommand(new Coordinate(Integer.parseInt(tab[0]),Integer.parseInt(tab[1])));
      }
      return res;
    }
  },
  DOUBLE_CLICK_COMMAND(DoubleClickCommand.DOUBLE_CLICK_COMMAND) {
    @Override
    public Command createCommand() {
      return DoubleClickCommand.DOUBLE_CLICK_COMMAND;
    }
  },
  MOUSE_LEFT_CLICK(MouseLeftClick.MOUSE_LEFT_CLICK) {
    @Override
    public Command createCommand() {
      return MouseLeftClick.MOUSE_LEFT_CLICK;
    }
  },
  MOUSE_RIGHT_CLICK(MouseRightClick.MOUSE_RIGHT_CLICK) {
    @Override
    public Command createCommand() {
      return MouseRightClick.MOUSE_RIGHT_CLICK;
    }
  },
  MOUSE_SCROLL_CLICK(MouseScrollClick.MOUSE_SCROLL_CLICK) {
    @Override
    public Command createCommand() {
      return MouseScrollClick.MOUSE_SCROLL_CLICK;
    }
  },
  LEFT_CLICK_FAST(new LeftClickVeryFast(1000)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Fast mouse left click");
      controller.textFieldLabel.setText("Time in milliseconds");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation){
        res = new LeftClickVeryFast(Long.parseLong(controller.textField.getText()));
      }
      return res;
    }
  },
  RIGHT_CLICK_FAST(new RightClickVeryFast(1000)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Fast mouse right click");
      controller.textFieldLabel.setText("Time in milliseconds");
      controller.textField.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation){
        res = new RightClickVeryFast(Long.parseLong(controller.textField.getText()));
      }
      return res;
    }
  },
  SET(new SetCommand("aha",0)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Set");
      controller.textFieldLabel.setText("Name of variable");
      controller.labelSecond.setText("Value");
      controller.labelSecond.setDisable(false);
      controller.textFieldSecond.setDisable(false);
      controller.textFieldSecond.setText("");
      controller.textFieldSecond.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new SetCommand(controller.textField.getText(), Integer.parseInt(controller.textFieldSecond.getText()));
      }
      controller.labelSecond.setDisable(true);
      controller.textFieldSecond.setDisable(true);
      controller.textFieldSecond.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      return res;
    }
  },
  ADD(new AddCommand("aha", 0)){
    @Override
    public Command createCommand() {
      AddCommandController controller = AddCommandWindow.getController();
      controller.reload();
      Stage stage = AddCommandWindow.getStage();
      stage.setTitle("Set");
      controller.textFieldLabel.setText("Name of variable");
      controller.labelSecond.setText("Value to add");
      controller.labelSecond.setVisible(true);
      controller.textFieldSecond.setVisible(true);
      controller.textFieldSecond.setText("");
      controller.textFieldSecond.addEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      stage.showAndWait();
      Command res = null;
      if(controller.successful_creation) {
        res = new AddCommand(controller.textField.getText(), Integer.parseInt(controller.textFieldSecond.getText()));
      }
      controller.labelSecond.setVisible(false);
      controller.textFieldSecond.setVisible(false);
      controller.textFieldSecond.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
      return res;
    }
  };

  private final Command comm;

  Commands(Command comm) {
    this.comm = comm;
  }

  public Command get() {
    return comm;
  }

  public String getId() {
    return comm.getId();
  }

  /**
   * Method invoking after AddCommand button in project scene.
   * Later this may be moved to Command interface.
   *
   * @return created Command or null when creation process was cancelled.
   */
  public Command createCommand() {
    System.out.println("Commands::createCommand in " + this.name() + " is not implemented");
    return null;
  }
}
