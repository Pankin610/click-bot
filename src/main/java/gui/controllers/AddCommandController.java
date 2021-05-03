package gui.controllers;

import gui.applications.projecting.AddCommandWindow;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCommandController implements Controller {
    public Label textFieldLabel;
    public TextField textField;

    public boolean successful_creation = false;

    @Override
    public void reload() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addCommand() {
        successful_creation = true;
        closeButton();
    }

    public void closeButton() {
        AddCommandWindow.close();
    }
}
