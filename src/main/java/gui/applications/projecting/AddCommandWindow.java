package gui.applications.projecting;

import gui.WindowsManager;
import gui.applications.SideWindow;
import gui.controllers.AddCommandController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCommandWindow implements SideWindow {
    private final static AddCommandController controller;
    private final static Stage stage = new Stage();

    static{
        FXMLLoader loader = WindowsManager.getLoader("add_command");
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Add Command");
        stage.setResizable(false);
        stage.initOwner(WindowsManager.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        controller = loader.getController();
    }

    public static AddCommandController getController(){
        return controller;
    }

    public static void show(){
        stage.show();
    }

    public static void close(){
        stage.close();
    }

    public static Stage getStage() {
        return stage;
    }
}
