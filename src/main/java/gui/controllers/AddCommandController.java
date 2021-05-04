package gui.controllers;

import gui.applications.projecting.AddCommandWindow;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCommandController implements Controller {
    public Label textFieldLabel;
    public TextField textField;

    public boolean successful_creation = false;
    public Button utilityButton;

    @Override
    public void reload() {
        // clearing filters and handlers
        textField.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
        textField.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.consumeTyped);
        textField.removeEventFilter(KeyEvent.KEY_PRESSED, AddCommandWindow.codeOfKey);
        // tiding utility button
        utilityButton.setVisible(false);
        utilityButton.setText("Utility");
        // default options
        successful_creation = false;
        textFieldLabel.setText("Default");
        AddCommandWindow.getStage().setTitle("Default");
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
