package gui.controllers;

import gui.WindowsManager;
import gui.applications.AboutWindow;
import gui.applications.ListOfProgramsWindow;
import gui.applications.ProgramNameWindow;
import gui.applications.StartWindow;
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
        setActiveProject(true);
        ProgramNameWindow.show();
    }

    public void aboutAction() {
        AboutWindow.show();
    }

    public void openAction() {
        setActiveProject(true);
        ListOfProgramsWindow.show();
    }

    public void settingsAction() {
    }

    public void saveProject() {
    }

    public void closeProject() {
        setActiveProject(false);
        StartWindow.show();
    }

    @Override
    public void reload() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
