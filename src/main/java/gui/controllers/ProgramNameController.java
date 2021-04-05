package gui.controllers;

import gui.applications.ProgramNameWindow;
import gui.applications.ProjectWindow;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgramNameController implements Controller{
    public Button createButton;
    public TextField testField;

    @Override
    public void reload() {
        testField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void createNew() {
        String name = testField.getText();
        ProgramNameWindow.close();
        ProjectWindow.show(name);
    }

    public String getName(){
        return testField.getText();
    }
}
