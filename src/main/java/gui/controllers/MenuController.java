package gui.controllers;

import gui.SceneType;
import gui.WindowsManager;
import gui.applications.*;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Controller{

    @FXML
    public MenuItem closeItem;
    @FXML
    public MenuBar menuBar;
    public MenuItem closeProjectItem;
    public MenuItem saveItem;

    private boolean activeProject = false;

    public boolean isActiveProject(){
        return activeProject;
    }

    public void setActiveProject(boolean f){
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
    }

    public void saveProject() {

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
