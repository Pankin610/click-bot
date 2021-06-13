package gui.applications;

import gui.Settings;
import gui.WindowsManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Starting class of whole application.
 */
public final class Main extends Application {
  public Main(){
    Image[] icons = WindowsManager.getIcons();
    for(int i=0;i<1;i++)
      icons[i] = new Image(Main.class.getResource("/graphics/icon" + i + ".png").toExternalForm());
  }

  @Override
  public void start(Stage stage) {
    WindowsManager.setStage(stage); /* calling setStage at start of the program */
    Settings.load();
    WindowsManager.startProgram();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
