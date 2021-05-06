package gui.controllers;

import exceptions.WrongFileFormatException;
import files.CreatedPrograms;
import gui.WindowsManager;
import gui.applications.ListOfProgramsWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfProgramsController implements Controller {
  @FXML
  public ListView<String> programList;
  public Button openButton;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    programList.getItems().addAll(CreatedPrograms.getNames());
    programList.setOnMouseClicked(mouseEvent -> {
      if (programList.getSelectionModel().getSelectedItems().size() > 0) popButton();
      if (mouseEvent.getButton().equals(MouseButton.PRIMARY) &&
              mouseEvent.getClickCount() == 2 &&
              programList.getSelectionModel().getSelectedItems().size() > 0)
        openAction();
    });
  }

  @Override
  public void reload() {
    programList.getItems().clear();
    openButton.setDisable(true);
    programList.getItems().addAll(CreatedPrograms.getNames());
  }

  public void popButton() {
    openButton.setDisable(false);
  }

  public void closeAction() {
    ListOfProgramsWindow.close();
  }

  public void openAction() {
    String name = programList.getSelectionModel().getSelectedItem();
    System.out.println(name);
    if (name == null || name.trim().isEmpty())
      throw new WrongFileFormatException("Problem during opening file (empty name)");
    ListOfProgramsWindow.close();
    WindowsManager.openExistingProject(name);
  }
}
