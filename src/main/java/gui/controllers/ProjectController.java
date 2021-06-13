package gui.controllers;

import files.reading.ReadFileObject;
import gui.SceneType;
import gui.WindowsManager;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import lang.commands.Command;
import lang.commands.Commands;
import lang.commands.single.AbstractSingleCommand;
import lang.variables.Variable;
import lang.variables.VariableDescription;
import util.builders.ProgramBuilder;
import util.containers.VariableContainer;
import util.containers.VariableList;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProjectController implements Controller {
  public Label nameProgramLabel;
  public MenuButton addCommandButton;
  public TreeTableView<Command> programTree;
  private TreeItem<Command> root;
  public TreeTableColumn<Command, String> programColumn;
  public TableView<Variable> variableList;
  public TableColumn<Variable, String> typeVariableList;
  public TableColumn<Variable, String> nameVariableList;
  public TableColumn<Variable, String> valueVariableList;
  public TextArea codeTextArea;

  public final VariableContainer variables = new VariableList();
  public AnchorPane mainPane;

  private SceneType mode = SceneType.PROJECT_SCENE_GRAPHIC;

  //list of menu items with commands from Commands enum
  private final List<MenuItem> commandList;
  private final List<MenuItem> appendCommandList;

  { // populating commandList
    commandList = new ArrayList<>();
    for (Commands element : Commands.values()) {
      MenuItem menu = new MenuItem(element.getId().toLowerCase().replace('_', ' '));
      menu.setOnAction(actionEvent -> {
        Command command = element.createCommand();
        if (command == null) return;
        if(mode == SceneType.PROJECT_SCENE_GRAPHIC) addCommandToGraphic(command);
        if(mode == SceneType.PROJECT_SCENE_TEXT)    addCommandToText(command);
        System.out.println(command.getStringRepresentation());
      });
      commandList.add(menu);
    }
    appendCommandList = new ArrayList<>();
    for (Commands element : Commands.values()) {
      MenuItem menu = new MenuItem(element.getId().toLowerCase().replace('_', ' '));
      menu.setOnAction(actionEvent -> {
        Command command = element.createCommand();
        if(command == null) return;
        appendCommand(command);
        System.out.println(command.getStringRepresentation());
      });
      appendCommandList.add(menu);
    }
  }

  private void appendCommand(Command command) {
    programTree.getSelectionModel().getSelectedItem().getChildren().add(command.getTreeRepresentation());
    programTree.refresh();
  }

  private void addCommandToText(Command command) {
    int cursor_position = codeTextArea.getCaretPosition();
    codeTextArea.insertText(cursor_position, command.getStringRepresentation());
  }

  private void addCommandToGraphic(Command command) {
    if(root.getChildren().isEmpty()){
      root.getChildren().add(command.getTreeRepresentation());
      return;
    }
    TreeItem<Command> selected = programTree.getSelectionModel().getSelectedItem();
    if (selected == null) {
      System.out.println("Select item in Tree!");
      return;
    }
    addAfter(selected, command.getTreeRepresentation());
    programTree.refresh();
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
  private final Menu appendComm;

  { //context menu for TreeView with program description
    contextMenuProgram = new ContextMenu();
    deleteComm = new MenuItem("Delete");
    deleteComm.setOnAction(actionEvent -> {
        TreeItem<Command> toDeletion = programTree.getSelectionModel().getSelectedItem();
        if (toDeletion == null || toDeletion.getParent() == null) return;
        toDeletion.getParent().getChildren().remove(toDeletion);
        programTree.refresh();
        programTree.getSelectionModel().clearSelection();
    });
    Menu addComm = new Menu("Add command");
    addComm.getItems().addAll(commandList);
    appendComm = new Menu("Append command");
    appendComm.getItems().addAll(appendCommandList);
    contextMenuProgram.getItems().addAll(addComm, appendComm, deleteComm);
  }

  @Override
  public void reload() {
    variables.clear();
    mode = SceneType.PROJECT_SCENE_GRAPHIC;
    programTree.setVisible(true);
    codeTextArea.setVisible(false);
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

    programTree.setOnContextMenuRequested(contextMenuEvent -> {
            deleteComm.setDisable(programTree.getSelectionModel().getSelectedItem() == null ||
                    programTree.getSelectionModel().getSelectedItem().getParent() == null);
            appendComm.setDisable(programTree.getSelectionModel().getSelectedItem() == null ||
                    !programTree.getSelectionModel().getSelectedItem().getValue().isGroup() ||
                    mode == SceneType.PROJECT_SCENE_TEXT);
    });

    variableList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    // Populating AddCommandButton SplitMenuButton
    addCommandButton.getItems().addAll(commandList);
  }

  private void initProgramTree() {
    programColumn.setCellValueFactory(p -> new ObservableValueBase<>() {
      @Override
      public String getValue() {
        return getIndent(p.getValue()) + p.getValue().getValue().toString();
      }
    });
    programColumn.setCellFactory(new Callback<>() {
      @Override
      public TreeTableCell<Command, String> call(TreeTableColumn<Command, String> commandStringTreeTableColumn) {
        Label label = new Label();
//        final Label anotherLabel = new Label("Item:");
        HBox hbox = new HBox(5, label);
        hbox.getStyleClass().add("tree-table-cell");
//        label.getStyleClass().add("label");
        TreeTableCell<Command, String> cell = new TreeTableCell<>() {
          @Override
          protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) setGraphic(null);
            else setGraphic(hbox);
          }
        };
        cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        cell.itemProperty().addListener((observableValue, s, t1) -> label.setText(t1 == null ? "" : t1));
        return cell;
      }
    });
    WindowsManager.scene.getStylesheets().add(getClass().getResource("tree-table-hover.css").toExternalForm());
  }

  private String getIndent(TreeItem<Command> item) {
    StringBuilder spaces = new StringBuilder("  ");
    while(item.getParent() != null){
      spaces.append("  ");
      item = item.getParent();
    }
    return spaces.toString();
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
    load(new ProgramBuilder(file));
  }

  public void load(ProgramBuilder program){
    this.reload();
    nameProgramLabel.setText(program.programName);
    loadCommands(program);
    /* load Variables */
    for (VariableDescription var : program.getVariablesDescription()) {
      variables.add(var.getVariable());
    }
    refreshVariables();
  }

  private void loadCommands(ProgramBuilder program) {
    root = new TreeItem<>(new AbstractSingleCommand() { /* small hack */
      @Override
      public String getId() {
        return program.programName;
      }
    });
    for (Command comm : program.getCommands()) {
      root.getChildren().add(comm.getTreeRepresentation());
    }
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
    variableList.getSelectionModel().clearSelection();
  }

  public void addAfter(TreeItem<Command> me, TreeItem<Command> item) {
    TreeItem<Command> parent = me.getParent();
    if (parent == null) return;
    ObservableList<TreeItem<Command>> list = parent.getChildren();
    int ind = list.indexOf(me);
    List<TreeItem<Command>> new_list = new ArrayList<>(list.subList(0, ind + 1));
    new_list.add(item);
    new_list.addAll(list.subList(ind + 1, list.size()));
    list.clear();
    list.addAll(new_list);
  }

  public void changeMode(SceneType type) {
    if(type == SceneType.PROJECT_SCENE_GRAPHIC && mode != type){
      Scanner scanner = new Scanner(new ByteArrayInputStream(codeTextArea.getText().getBytes(StandardCharsets.UTF_8)));
      ProgramBuilder program = new ProgramBuilder();
      program.loadCommands(scanner);
      program.programName = nameProgramLabel.getText();
      loadCommands(program);
      programTree.setVisible(true);
      codeTextArea.setVisible(false);
      mode = type;
    }
    if(type == SceneType.PROJECT_SCENE_TEXT && mode != type){
      codeTextArea.setText("");
      ProgramBuilder program = new ProgramBuilder(programTree.getRoot(), variables);
      for(Command command : program.getCommands()){
        codeTextArea.appendText(command.getStringRepresentation());
        codeTextArea.appendText("\n");
      }
      programTree.setVisible(false);
      codeTextArea.setVisible(true);
      mode = type;
    }
  }
}