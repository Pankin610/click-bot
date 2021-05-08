package gui.controllers;

import files.reading.ReadFileObject;
import gui.WindowsManager;
import javafx.beans.value.ObservableValueBase;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lang.commands.Command;
import lang.commands.Commands;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import util.builders.ProgramBuilder;
import util.containers.VariableContainer;
import util.containers.VariableList;
import util.gui.CodeItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectController implements Controller {
  public Label nameProgramLabel;
  public SplitMenuButton addCommandButton;
  public TreeView<String> programTree;
  public TableView<Variable> variableList;
  public TableColumn<Variable, String> typeVariableList;
  public TableColumn<Variable, String> nameVariableList;
  public TableColumn<Variable, String> valueVariableList;

  public final VariableContainer variables = new VariableList();
  public AnchorPane mainPane;

  private final List<MenuItem> commandList;

  { // populating commandList
    commandList = new ArrayList<>();
    for (Commands element : Commands.values()) {
      MenuItem menu = new MenuItem(element.getId().toLowerCase().replace('_', ' '));
      menu.setOnAction(actionEvent -> {
        Command command = element.createCommand();
        TreeItem<String> selected = programTree.getSelectionModel().getSelectedItem();
        if (selected == null) {
          System.out.println("Select item in Tree!");
          return;
        }
        if (command == null) return;
        CodeItem.addAfter(selected, command.getTreeRepresentation());
        programTree.refresh();
        System.out.println(command.getStringRepresentation());
      });
      commandList.add(menu);
    }
  }

  private final ContextMenu contextMenuVar;
  private final MenuItem deleteVar;

  { //context menu for TableView with variables
    contextMenuVar = new ContextMenu();
    MenuItem addVariable = new MenuItem("Add variable");
    addVariable.setOnAction(this::addVariable);
    deleteVar = new MenuItem("Delete");
    deleteVar.setOnAction(actionEvent -> {
      if (variableList.getItems().isEmpty() || variableList.getSelectionModel().getSelectedItems().isEmpty())
        return;
      ArrayList<Variable> toBeRemoved = new ArrayList<>(variableList.getSelectionModel().getSelectedItems());
      for (Variable var : toBeRemoved) variables.remove(var.getName());
      variableList.refresh();
    });
    contextMenuVar.getItems().addAll(addVariable, deleteVar);
  }

  private final ContextMenu contextMenuProgram;
  private final MenuItem deleteComm;
  { //program context menu
    contextMenuProgram = new ContextMenu();
    deleteComm = new MenuItem("Delete");
    deleteComm.setOnAction(actionEvent -> {
        TreeItem<String> toDeletion = programTree.getSelectionModel().getSelectedItem();
        if (toDeletion == null || toDeletion.getParent() == null) return;
        toDeletion.getParent().getChildren().remove(toDeletion);
        programTree.refresh();
    });
    Menu addComm = new Menu("Add command");
    addComm.getItems().addAll(commandList);
    contextMenuProgram.getItems().addAll(addComm, deleteComm);
  }

  public void addCommandWindow() {

  }

  @Override
  public void reload() {
    variables.clear();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // Type column
    initTypeColumn();
    // Name column
    initNameColumn();
    // Value column
    initValueColumn();

    variableList.getColumns().addAll(typeVariableList, nameVariableList, valueVariableList);

    //setting context menus
    variableList.setContextMenu(contextMenuVar);
    programTree.setContextMenu(contextMenuProgram);

    // disabling delete button if nothing is selected - so far, it is not working in all cases
    variableList.setOnContextMenuRequested(contextMenuEvent ->
            deleteVar.setDisable(variableList.getItems().isEmpty() ||
                    variableList.getSelectionModel().getSelectedItems().isEmpty()));

    programTree.setOnContextMenuRequested(contextMenuEvent ->
            deleteComm.setDisable(programTree.getSelectionModel().getSelectedItem() == null ||
                    programTree.getSelectionModel().getSelectedItem().getParent() == null));

    TableView.TableViewSelectionModel<Variable> selectionModel = variableList.getSelectionModel();
    selectionModel.setSelectionMode(SelectionMode.MULTIPLE);

    // Populating AddCommandButton SplitMenuButton
    addCommandButton.getItems().addAll(commandList);
  }

  private void initValueColumn() {
    valueVariableList = new TableColumn<>("Value");
    valueVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
      @Override
      public String getValue() {
        return p.getValue().getStringValue();
      }
    });
    valueVariableList.setPrefWidth(75);
    valueVariableList.sortableProperty().setValue(false);
  }

  private void initNameColumn() {
    nameVariableList = new TableColumn<>("Name");
    nameVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
      @Override
      public String getValue() {
        return p.getValue().getName();
      }
    });
    nameVariableList.setPrefWidth(75);
    nameVariableList.sortableProperty().setValue(false);
  }

  private void initTypeColumn() {
    typeVariableList = new TableColumn<>("Type");
    typeVariableList.setCellValueFactory(p -> new ObservableValueBase<>() {
      @Override
      public String getValue() {
        return p.getValue().getId();
      }
    });
    typeVariableList.setPrefWidth(50);
    typeVariableList.sortableProperty().setValue(false);
  }

  /**
   * Loads tree representation of program inside file.
   *
   * @param file {@link ReadFileObject} with description of program
   */
  public void load(ReadFileObject file) {
    this.reload();
    ProgramBuilder program = new ProgramBuilder(file);
    nameProgramLabel.setText(program.programName);
    TreeItem<String> root = new TreeItem<>(program.programName); /* load Commands */
    for (Command comm : program.getCommands()) {
      root.getChildren().add(comm.getTreeRepresentation());
    }
    for (VariableDescription var : program.getVariablesDescription()) { /* load Variables */
      variables.add(var.getVariable());
    }
    variableList.setItems(variables);
    programTree.setRoot(root);
  }

  public VariableContainer getVariables() {
    return variables;
  }

  public void addVariable(ActionEvent e) {
    WindowsManager.addVariable();
  }
}
