package gui.controllers;

import files.Paths;
import files.writing.WriteFileObject;
import gui.SceneType;
import gui.WindowsManager;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import lang.CodeFragment;
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

  private boolean activeProject = false;

  public boolean isActiveProject() {
    return activeProject;
  }

  public void setActiveProject(boolean f) {
    activeProject = f;
    saveItem.setDisable(!f);
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
  public void saveProject() throws IOException { /* for now, variables are omitted */
    /* root of current project */
    TreeItem<CodeFragment> root = WindowsManager.getRootOfProject();

    /* variables of current project */
    VariableContainer vars = WindowsManager.getProjectVariables();

    /* creating program based on collected data */
    ProgramBuilder program = new ProgramBuilder(root, vars);

    /* path to file, where program should be saved */ //for now, all programs are saved to tmp file.
    String path = Paths.PATH_WITH_PROGRAMS.getPath() + /* program.programName*/ "tmp" + ".txt";

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
}
