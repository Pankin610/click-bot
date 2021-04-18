package gui.controllers;

import files.reading.ReadFileObject;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import lang.commands.Command;
import util.builders.ProgramBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectController implements Controller {
    public Label nameProgramLabel;
    public SplitMenuButton addVariableButton;
    public SplitMenuButton addCommandButton;
    public TreeView<String> programTree;

    public void addCommandWindow(ActionEvent actionEvent) {
    }

    public void addVariableWindow(ActionEvent actionEvent) {
    }

    @Override
    public void reload() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Loads tree representation of program inside file.
     * @param file {@link ReadFileObject} with description of program
     */
    public void load(ReadFileObject file){
        ProgramBuilder program = new ProgramBuilder(file);
        nameProgramLabel.setText(program.programName);
        TreeItem<String> root = new TreeItem<>(program.programName);
        for(Command comm : program.getCommands()){
            root.getChildren().add(comm.getTreeRepresentation());
        }
        programTree.setRoot(root);
    }
}
