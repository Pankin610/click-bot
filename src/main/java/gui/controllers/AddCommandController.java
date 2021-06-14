package gui.controllers;

import gui.applications.projecting.AddCommandWindow;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCommandController implements Controller {
  public Label textFieldLabel;
  public TextField textField;

  public boolean successful_creation = false;
  public Button utilityButton;
  public TextArea textArea;
  public TextField textFieldSecond;
  public Label labelSecond;

  @Override
  public void reload() {
    // clearing filters and handlers
    textField.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.numericOnly);
    textField.removeEventFilter(KeyEvent.KEY_TYPED, AddCommandWindow.consumeTyped);
    textField.removeEventFilter(KeyEvent.KEY_PRESSED, AddCommandWindow.codeOfKey);
    textField.removeEventFilter(KeyEvent.KEY_PRESSED, AddCommandWindow.cords);
    // tiding utility button
    utilityButton.setVisible(false);
    utilityButton.setText("Utility");
    // default options
    textField.setVisible(true);
    textFieldSecond.setVisible(false);
    textArea.setVisible(false);
    labelSecond.setVisible(false);
    textField.setPromptText("");
    successful_creation = false;
    textFieldLabel.setText("Default");
    textField.setText("");
    textArea.setText("");
    textArea.setVisible(false);

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
