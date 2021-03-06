package gui.applications.projecting;

import gui.WindowsManager;
import gui.applications.SideWindow;
import gui.controllers.AddCommandController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Coordinate;

import java.awt.*;
import java.io.IOException;

public class AddCommandWindow implements SideWindow {
  private final static AddCommandController controller;
  private final static Stage stage = new Stage();

  static {
    FXMLLoader loader = WindowsManager.getLoader("add_command");
    try {
      stage.setScene(new Scene(loader.load()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    stage.setTitle("Add Command");
    stage.setResizable(false);
    stage.getIcons().addAll(WindowsManager.getIcons());
    stage.initOwner(WindowsManager.stage);
    stage.initModality(Modality.APPLICATION_MODAL);
    controller = loader.getController();
  }

  public static EventHandler<KeyEvent> numericOnly = keyEvent -> {
    if (!"-0123456789".contains(keyEvent.getCharacter())) keyEvent.consume();
  };

  public static EventHandler<KeyEvent> codeOfKey = keyEvent -> {
    System.out.println(keyEvent.getCode().getCode());
    controller.textField.setText(String.valueOf(keyEvent.getCode().getCode()));
    keyEvent.consume();
  };

  public static EventHandler<KeyEvent> consumeTyped = Event::consume;

  public static EventHandler<KeyEvent> cords = keyEvent -> {
    if(keyEvent.getCharacter().equals("q")) {
      Coordinate cords = new Coordinate(MouseInfo.getPointerInfo().getLocation());
      controller.textField.setText(cords.x + " "  + cords.y);
      keyEvent.consume();
    }
  };

  public static AddCommandController getController() {
    return controller;
  }

  public static void show() {
    stage.show();
  }

  public static void close() {
    stage.close();
  }

  public static Stage getStage() {
    return stage;
  }
}
