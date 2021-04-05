package gui.applications;

import gui.WindowsManager;
import gui.controllers.AboutController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AboutWindow implements SideWindow {
    private static final AboutController controller;
    private static final Stage stage = new Stage();
    static{
        FXMLLoader loader = new FXMLLoader(WindowsManager.class.getResource("scenes/about.fxml"));
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller = loader.getController();
        stage.setResizable(false);
        stage.setTitle("About Click-bot");
    }

    public static AboutController getController() {
        return controller;
    }

    public static void show(){
        stage.show();
    }
}
