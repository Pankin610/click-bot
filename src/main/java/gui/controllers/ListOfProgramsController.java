package gui.controllers;

import exceptions.WrongFileFormatException;
import files.CreatedPrograms;
import files.reading.ReadFileObject;
import gui.applications.ListOfProgramsWindow;
import gui.applications.ProgramMenu;
import gui.applications.ProjectWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfProgramsController implements Controller {
    @FXML
    public ListView<String> programList;
    public Button openButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        programList.getItems().addAll(CreatedPrograms.getNames());
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
        if(name == null)    throw new WrongFileFormatException("problem during opening file");
        ListOfProgramsWindow.close();
        ProjectWindow.show(CreatedPrograms.getFileByName(name));
        ProgramMenu.settingProjectScene();
    }
}
