package gui.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import lang.commands.Commands;
import lang.variables.Variables;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Controller {
    public TextArea mainLabel;

    @Override
  public void reload() {

  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    StringBuilder text = new StringBuilder();
    for(Commands com : Commands.values()){
      text.append(com.get().getPattern()).append('\n');
    }
    mainLabel.setText(text.toString());
  }
}
