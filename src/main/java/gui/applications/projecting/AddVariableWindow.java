package gui.applications.projecting;

import gui.WindowsManager;
import gui.applications.SideWindow;
import gui.controllers.AddVariableController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddVariableWindow implements SideWindow {
  private final static AddVariableController controller;
  private final static Stage stage = new Stage();

  static {
    FXMLLoader loader = WindowsManager.getLoader("add_variable");
    try {
      stage.setScene(new Scene(loader.load()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    stage.setResizable(false);
    stage.getIcons().addAll(WindowsManager.getIcons());
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initOwner(WindowsManager.stage);
    stage.setTitle("Add variable");
    controller = loader.getController();
  }

  public static void show() {
    controller.reload();
    stage.show();
  }

  public static void close() {
    stage.close();
  }

}
