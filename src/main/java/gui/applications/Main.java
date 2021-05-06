package gui.applications;

import gui.WindowsManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting class of whole application.
 */
public final class Main extends Application {
  @Override
  public void start(Stage stage) {
    WindowsManager.setStage(stage); /* calling setStage at start of the program */
    WindowsManager.startProgram();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
