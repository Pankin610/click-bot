package gui.controllers;

import files.Paths;
import files.writing.WriteFileObject;
import gui.SceneType;
import gui.WindowsManager;
import gui.applications.projecting.ProjectWindow;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import lang.commands.Command;
import util.builders.ProgramBuilder;
import util.containers.VariableContainer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Controller {

  public MenuItem closeItem;
  public MenuBar menuBar;
  public MenuItem closeProjectItem;
  public MenuItem saveItem;
  public ToggleGroup ModeGroup;
  public MenuItem runItem;

  private boolean activeProject = false;

  public boolean isActiveProject() {
    return activeProject;
  }

  public void setActiveProject(boolean f) {
    activeProject = f;
    saveItem.setDisable(!f);
    runItem.setDisable(!f);
    closeProjectItem.setDisable(!f);
  }

  public void closeAction() {
    WindowsManager.closeProgram();
  }

  public void newAction() {
    WindowsManager.openNewDialog();
  }

  public void aboutAction() {
    WindowsManager.showAboutWindow();
  }

  public void openAction() {
    WindowsManager.showListOfProgram();
  }

  public void settingsAction() {
    WindowsManager.showSettingsWindow();
  }

  /**
   * Corresponds to {@link #saveItem}. Saves current project inside file with same name as project.
   * Overrides existing files.
   * For now, all saving operations are redirected to tmp.txt file.
   *
   * @throws IOException when something with file opening gone wrong.
   */
  public void saveProject() throws IOException {
    ProgramBuilder program = null;
    if(WindowsManager.getSceneType() == SceneType.PROJECT_SCENE_GRAPHIC) {
      /* root of current project */
      TreeItem<Command> root = WindowsManager.getRootOfProject();

      /* variables of current project */
      VariableContainer vars = WindowsManager.getProjectVariables();

      /* creating program based on collected data */
      program = new ProgramBuilder(root, vars);
    }
    else{
      /* variables of current project */
      VariableContainer vars = WindowsManager.getProjectVariables();

      /* code of program */
      program = new ProgramBuilder(ProjectWindow.getController().nameProgramLabel.getText(),
              ProjectWindow.getController().codeTextArea.getText(),vars);
    }
    /* path to file, where program should be saved */
    String path = Paths.PATH_WITH_PROGRAMS.getPath() + program.programName + ".txt";

    program.viewCommands(); /* only for testing */

    /* preparing WriteFileObject */
    WriteFileObject file = new WriteFileObject(path);

    /* saving program to file */
    program.saveToFile(file);
  }

  public void closeProject() {
    WindowsManager.changeScene(SceneType.START_SCENE);
  }

  @Override
  public void reload() {

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  public void changeToGraphic() {
    WindowsManager.changeMode(SceneType.PROJECT_SCENE_GRAPHIC);
  }

  public void changeToText() {
    WindowsManager.changeMode(SceneType.PROJECT_SCENE_TEXT);
  }

  public void runProgram() {
    WindowsManager.runProgram();
  }
}
