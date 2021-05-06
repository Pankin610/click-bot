package gui.controllers;

import gui.applications.features.SettingsWindow;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Controller {

  public AnchorPane mainPane;
  public Button closeButton;

  @Override
  public void reload() {

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  public void closeAction() {
    SettingsWindow.close();
  }
}
