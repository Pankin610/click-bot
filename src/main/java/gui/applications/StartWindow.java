package gui.applications;

import gui.WindowsManager;
import gui.controllers.StartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class StartWindow implements SideWindow {
    private static final Pane pane;
    private static final StartController controller;
    static{
        FXMLLoader loader = new FXMLLoader(WindowsManager.class.getResource("scenes/start.fxml"));
        Pane tmpPane = null;
        try {
            tmpPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane = tmpPane;
        controller = loader.getController();
    }
    public static StartController getController() {
        return controller;
    }

    public static Pane getPane() {
        return pane;
    }

    public static void show(){
        controller.reload();
        WindowsManager.root.setCenter(pane);
    }
}
