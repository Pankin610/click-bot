package gui.controllers;

import environments.Console;
import environments.Environment;
import files.CreatedPrograms;
import files.reading.ReadFileObject;
import gui.applications.ListOfProgramsWindow;
import gui.applications.ProgramNameWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import program.Program;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Controller {

    @FXML
    private Pane mainPain;
    @FXML
    private Button runProgramButton, openExistingButton, createNewButton;
    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(CreatedPrograms.getNames());
        choiceBox.setOnAction(this::removeDisabledRunButton);
    }

    public void createNew(){
        ProgramNameWindow.show();
    }

    public void openExisting(ActionEvent event){
        ListOfProgramsWindow.show();
    }

    public void runProgram(ActionEvent event){
        String name = choiceBox.getValue();
        Program program = Program.getProgramFromFile(new ReadFileObject(CreatedPrograms.getPathByName(name)));
        Environment envi = new Console(program); /* for now, program is executed in default environment (which is Console) */
        envi.runProgram();
    }

    public void removeDisabledRunButton(ActionEvent event){
        runProgramButton.setDisable(false);
    }

    @Override
    public void reload() {
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(CreatedPrograms.getNames());
    }
}
