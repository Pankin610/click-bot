package gui.controllers;

import files.reading.ReadFileObject;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lang.commands.Command;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import util.builders.ProgramBuilder;
import util.containers.VariableContainer;
import util.containers.VariableList;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectController implements Controller {
    public Label nameProgramLabel;
    public SplitMenuButton addVariableButton;
    public SplitMenuButton addCommandButton;
    public TreeView<String> programTree;
    public TableView<Variable> variableList;
    public TableColumn<Variable, String> typeVariableList;
    public TableColumn<Variable, String> nameVariableList;
    public TableColumn<Variable, String> valueVariableList;

    private final VariableContainer variables = new VariableList();
    public AnchorPane mainPane;

    public void addCommandWindow() {

    }

    public void addVariableWindow() {

    }

    @Override
    public void reload() {
        variables.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
            @Override
            public String getValue() {
                return p.getValue().getId();
            }
        });
        nameVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
            @Override
            public String getValue() {
                return p.getValue().getName();
            }
        });
        valueVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
            @Override
            public String getValue() {
                return p.getValue().getStringValue();
            }
        });
    }

    /**
     * Loads tree representation of program inside file.
     * @param file {@link ReadFileObject} with description of program
     */
    public void load(ReadFileObject file){
        this.reload();
        ProgramBuilder program = new ProgramBuilder(file);
        nameProgramLabel.setText(program.programName);
        TreeItem<String> root = new TreeItem<>(program.programName); /* load Commands */
        for(Command comm : program.getCommands()){
            root.getChildren().add(comm.getTreeRepresentation());
        }
        for(VariableDescription var : program.getVariablesDescription()){ /* load Variables */
            variables.add(var.getVariable());
        }
        variableList.setItems(FXCollections.observableList(variables));
        programTree.setRoot(root);
    }

    public VariableContainer getVariables() {
        return variables;
    }
}
