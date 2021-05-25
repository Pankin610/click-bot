package gui.controllers;

import exceptions.NoUniqueVariableNameException;
import gui.WindowsManager;
import gui.applications.projecting.AddVariableWindow;
import gui.applications.projecting.ProjectWindow;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import lang.CodeFactory;
import lang.variables.Variable;
import lang.variables.Variables;
import util.bot.Bot;

import java.net.URL;
import java.util.ResourceBundle;

public class AddVariableController implements Controller {
  public ChoiceBox<String> TypeChoiceBox;
  public TextField VariablesNameBox;
  public TextField InitialValueBox;

  @Override
  public void reload() {
    VariablesNameBox.setText("");
    InitialValueBox.setText("");
    TypeChoiceBox.setValue("");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    TypeChoiceBox.getItems().addAll(Variables.getIds());
  }

  public void addVariable() {
    String type = TypeChoiceBox.getValue();
    String name = VariablesNameBox.getText();
    String value = InitialValueBox.getText();
    Variable var = CodeFactory.parseVariable(type + ' ' + name + ' ' + value);
    ProjectController controller = ProjectWindow.getController();
    try {
      controller.variables.add(var);
      controller.refreshVariables();
    } catch (NoUniqueVariableNameException e) {
      new Bot().beep();
      System.out.println(e.getName() + " already exists");
    }
    AddVariableWindow.close();
  }

  public void getPixelColor() {
    InitialValueBox.setText(String.valueOf(WindowsManager.getPixelColor().getRGB()));
  }

  public void getCursorCords() {
    InitialValueBox.setText(WindowsManager.getCords().toString());
  }
}
