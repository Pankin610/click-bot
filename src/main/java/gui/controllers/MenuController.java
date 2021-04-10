package gui.controllers;

import gui.WindowsManager;
import gui.applications.AboutWindow;
import gui.applications.ListOfProgramsWindow;
import gui.applications.ProgramNameWindow;
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

    public void closeAction() {
        WindowsManager.closeProgram();
    }

    public void newAction() {
        ProgramNameWindow.show();
    }

    public void aboutAction() {
        AboutWindow.show();
    }

    public void openAction() {
        ListOfProgramsWindow.show();
    }

    public void settingAction() {
    }

    public void saveProject() {
    }

    public void closeProject() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
