package gui.applications;

import gui.WindowsManager;
import gui.controllers.ProgramNameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Class responsible for pop-up window which shows before creation of new project.
 */
public abstract class ProgramNameWindow implements SideWindow {
  private final static ProgramNameController controller;
  private final static Stage stage = new Stage();

  static {
    FXMLLoader loader = WindowsManager.getLoader("program_name");
    try {
      stage.setScene(new Scene(loader.load()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    stage.setResizable(false);
    stage.setTitle("Program's name");
    stage.getIcons().addAll(WindowsManager.getIcons());
    stage.initOwner(WindowsManager.stage);
    stage.initModality(Modality.APPLICATION_MODAL);
    controller = loader.getController();
  }

  public static ProgramNameController getController() {
    return controller;
  }

  public static String getName() {
    return controller.testField.getText();
  }

  public static Stage getStage() {
    return stage;
  }

  public static void show() {
    stage.show();
  }

  public static void close() {
    stage.close();
  }

  public static void reload() {
    controller.reload();
  }
}
