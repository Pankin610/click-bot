package gui.controllers;

import files.reading.ReadFileObject;
import gui.WindowsManager;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lang.CodeFragment;
import lang.commands.Command;
import lang.commands.Commands;
import lang.variables.StringVariable;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import util.builders.ProgramBuilder;
import util.containers.VariableContainer;
import util.containers.VariableList;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectController implements Controller {
  public Label nameProgramLabel;
  public SplitMenuButton addCommandButton;
  public TreeTableView<CodeFragment> programTree;
  public TreeTableColumn<CodeFragment, String> programColumn;
  public TableView<Variable> variableList;
  public TableColumn<Variable, String> typeVariableList;
  public TableColumn<Variable, String> nameVariableList;
  public TableColumn<Variable, String> valueVariableList;

  public final VariableContainer variables = new VariableList();
  public AnchorPane mainPane;

  //list of menu items with commands from Commands enum
  private final List<MenuItem> commandList;

  { // populating commandList
    commandList = new ArrayList<>();
    for (Commands element : Commands.values()) {
      MenuItem menu = new MenuItem(element.getId().toLowerCase().replace('_', ' '));
      menu.setOnAction(actionEvent -> {
        Command command = element.createCommand();
        TreeItem<CodeFragment> selected = programTree.getSelectionModel().getSelectedItem();
        if (selected == null) {
          System.out.println("Select item in Tree!");
          return;
        }
        if (command == null) return;
        addAfter(selected, command.getTreeRepresentation());
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
      refreshVariables();
    });
    contextMenuVar.getItems().addAll(addVariable, deleteVar);
  }

  private final ContextMenu contextMenuProgram;
  private final MenuItem deleteComm;

  { //context menu for TreeView with program description
    contextMenuProgram = new ContextMenu();
    deleteComm = new MenuItem("Delete");
    deleteComm.setOnAction(actionEvent -> {
        TreeItem<CodeFragment> toDeletion = programTree.getSelectionModel().getSelectedItem();
        if (toDeletion == null || toDeletion.getParent() == null) return;
        toDeletion.getParent().getChildren().remove(toDeletion);
        programTree.refresh();
    });
    Menu addComm = new Menu("Add command");
    addComm.getItems().addAll(commandList);
    contextMenuProgram.getItems().addAll(addComm, deleteComm);
  }

  @Override
  public void reload() {
    variables.clear();
    refreshVariables();
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // Type column
    initTypeColumn();
    // Name column
    initNameColumn();
    // Value column
    initValueColumn();

    // Program tree
    initProgramTree();

    //noinspection unchecked
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

    variableList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    // Populating AddCommandButton SplitMenuButton
    addCommandButton.getItems().addAll(commandList);
  }

  private void initProgramTree() {
    programColumn.setCellValueFactory(p -> new ObservableValueBase<>() {
      @Override
      public String getValue() {
        return p.getValue().getValue().toString();
      }
    });
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
   * @param file {@link ReadFileObject} with description of program
   */
  public void load(ReadFileObject file) {
    this.reload();
    ProgramBuilder program = new ProgramBuilder(file);
    nameProgramLabel.setText(program.programName);
    /* load Commands */
    TreeItem<CodeFragment> root = new TreeItem<>(new StringVariable("root", program.programName));
    for (Command comm : program.getCommands()) {
      root.getChildren().add(comm.getTreeRepresentation());
    }
    /* load Variables */
    for (VariableDescription var : program.getVariablesDescription()) {
      variables.add(var.getVariable());
    }
    refreshVariables();
    programTree.setRoot(root);
  }

  /**
   * @return container with variables
   */
  public VariableContainer getVariables() {
    return variables;
  }

  @SuppressWarnings("unused")
  public void addVariable(ActionEvent e) {
    WindowsManager.addVariable();
  }

  /**
   * Refreshes TableView with variables.
   * Forces TableView to hard refresh (view, selectable items, possible indices etc)
   */
  public void refreshVariables() {
    variableList.setItems(null);
    variableList.setItems(variables);
  }

  public void addAfter(TreeItem<CodeFragment> me, TreeItem<CodeFragment> item) {
    TreeItem<CodeFragment> parent = me.getParent();
    if (parent == null) return;
    ObservableList<TreeItem<CodeFragment>> list = parent.getChildren();
    int ind = list.indexOf(me);
    List<TreeItem<CodeFragment>> new_list = new ArrayList<>(list.subList(0, ind + 1));
    new_list.add(item);
    new_list.addAll(list.subList(ind + 1, list.size()));
    list.clear();
    list.addAll(new_list);
  }
}

// just notes, may be useful later
//    programTree.setShowRoot(false);
//    programTree.setCellFactory(new Callback<>() {
//      @Override
//      public TreeCell<String> call(TreeView<String> treeView) {
//        Label label = new Label();
//        HBox hbox = new HBox(5, label);
//        TreeCell<String> cell = new TreeCell<>(){
//          @Override
//          protected void updateItem(String item, boolean empty) {
//            super.updateItem(item, empty);
//            if(empty) setGraphic(null);
//            else  setGraphic(hbox);
//          }
//        };
//        cell.itemProperty().addListener((observableValue, s, t1) -> label.setText(t1 == null ? "" : t1));
//        return cell;
//      }
//    });
