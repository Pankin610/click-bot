package gui.controllers;

import gui.WindowsManager;
import gui.applications.features.ErrorAlert;
import gui.applications.ProgramNameWindow;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgramNameController implements Controller {
    public Button createButton;
    public TextField testField;

    @Override
    public void reload() {
        testField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * This method is called when Create New button is pressed.
     * It checks validity of entered name and show error messages when it is not correct.
     */
    public void createNew() {
        if(testField.getText() == null || testField.getText().trim().isEmpty() ) {
            ErrorAlert.showErrorAlert("Name of program cannot be empty.",ProgramNameWindow.getStage());
            return;
        }
        String name = testField.getText();
        if(name.contains(" ")){
            ErrorAlert.showErrorAlert("Name of program cannot contain spaces.",ProgramNameWindow.getStage());
            return;
        }
        ProgramNameWindow.close();
        WindowsManager.openNewProject(name);
    }

    public String getName(){
        return testField.getText();
    }
}
