package gui.applications;

import gui.WindowsManager;
import gui.controllers.SettingsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsWindow implements SideWindow {
    private final static SettingsController controller;
    private final static Stage stage = new Stage();
    static{
        FXMLLoader loader = WindowsManager.getLoader("settings");
        try{
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Settings");
        stage.initOwner(WindowsManager.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        controller = loader.getController();
    }

    public static SettingsController getController(){
        return controller;
    }

    public static void show(){
        stage.show();
    }

    public static void close(){
        stage.close();
    }
}
