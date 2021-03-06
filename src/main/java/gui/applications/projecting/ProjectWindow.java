package gui.applications.projecting;

import files.reading.ReadFileObject;
import gui.WindowsManager;
import gui.applications.SideWindow;
import gui.controllers.ProjectController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Pane;
import lang.commands.single.AbstractSingleCommand;

import java.io.IOException;

/**
 * Project window is responsible for project-creating scene of main program.
 */
public abstract class ProjectWindow implements SideWindow {
  private static final Pane pane;
  private static final ProjectController controller;

  static {
    FXMLLoader loader = WindowsManager.getLoader("project");
    Pane tmpPane = null;
    try {
      tmpPane = loader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    pane = tmpPane;
    controller = loader.getController();
  }

  public static ProjectController getController() {
    return controller;
  }

  public static Pane getPane() {
    return pane;
  }

  public static void prepareNew(String name) {
    controller.nameProgramLabel.setText(name);
    controller.root = new TreeItem<>(new AbstractSingleCommand() { /* small hack */
      @Override
      public String getId() {
        return name;
      }
    });
    controller.programTree.setRoot(controller.root);
  }

  public static void prepareExisting(ReadFileObject file) {
    controller.load(file);
  }
}
