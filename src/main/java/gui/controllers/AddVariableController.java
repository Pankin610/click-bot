package gui.controllers;

import gui.WindowsManager;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import lang.variables.Variables;

import java.net.URL;
import java.util.ResourceBundle;

public class AddVariableController implements Controller {
    public ChoiceBox<String> TypeChoiceBox;
    public TextField VariablesNameBox;
    public TextField InitialValueBox;

    @Override
    public void reload() {
        VariablesNameBox.setText("");
        InitialValueBox.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeChoiceBox.getItems().addAll(Variables.getIds());
    }

    public void addVariable() {
        //TODO
    }

    public void getPixelColor() {
        InitialValueBox.setText(String.valueOf(WindowsManager.getPixelColor().getRGB()));
    }

    public void getCursorCords() {
        InitialValueBox.setText(WindowsManager.getCords().toString());
    }
}
