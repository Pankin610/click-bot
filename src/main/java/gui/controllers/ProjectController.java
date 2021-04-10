package gui.controllers;

import files.reading.ReadFileObject;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import lang.commands.Command;
import lang.commands.group.GroupCommand;
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

    public void load(ReadFileObject file){
        ProgramBuilder program = new ProgramBuilder(file);
        nameProgramLabel.setText(program.programName);
        TreeItem<String> root = new TreeItem<>(program.programName);
        for(Command com : program.getCommands()){
            if(com != Command.NOTHING)
                root.getChildren().add(createNode(com));
        }
        programTree.setRoot(root);
    }

    private TreeItem<String> createNode(Command com){
        if(com instanceof GroupCommand){
            return createGroupNode((GroupCommand) com);
        }
        return new TreeItem<>(com.getStringRepresentation());
    }

    private TreeItem<String> createGroupNode(GroupCommand command){
        TreeItem<String> root = new TreeItem<>(command.getId());
        for(Command com : command){
            root.getChildren().add(createNode(com));
        }
        return root;
    }
}
