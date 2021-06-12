package gui.controllers;

import gui.Settings;
import gui.applications.features.ErrorAlert;
import gui.applications.features.SettingsWindow;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Controller {

  public AnchorPane mainPane;
  public Button closeButton;
  public TextField delayField;
  public int DELAY;

  @Override
  public void reload() {
    delayField.setText(String.valueOf(Settings.getDelay()));
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    reload();
  }

  public void closeAction() {
    SettingsWindow.close();
  }

  public void apply() {
    try{
      DELAY = Integer.parseInt(delayField.getText());
      if(DELAY <= 0)  throw new NumberFormatException();
    } catch(NumberFormatException e){
      ErrorAlert.showErrorAlert("Incorrect value", SettingsWindow.getStage());
      return;
    }
    Settings.load(this);
  }
}
