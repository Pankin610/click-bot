package gui.applications.features;

import gui.WindowsManager;
import gui.applications.SideWindow;
import gui.controllers.AboutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is responsible for separate window with information about project.
 */
public abstract class AboutWindow implements SideWindow {
  private static final AboutController controller;
  private static final Stage stage = new Stage();

  static {
    FXMLLoader loader = WindowsManager.getLoader("about");
    try {
      stage.setScene(new Scene(loader.load()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    controller = loader.getController();
    stage.setResizable(false);
    stage.getIcons().addAll(WindowsManager.getIcons());
    stage.initOwner(WindowsManager.stage);
    stage.setTitle("Glossary");
  }

  public static AboutController getController() {
    return controller;
  }

  public static void show() {
    stage.show();
  }
}
