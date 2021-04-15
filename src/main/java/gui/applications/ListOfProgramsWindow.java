package gui.applications;

import gui.WindowsManager;
import gui.controllers.ListOfProgramsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract  class ListOfProgramsWindow implements SideWindow {
    private final static ListOfProgramsController controller;
    private final static Stage stage = new Stage();
    static{
        FXMLLoader loader = new FXMLLoader(WindowsManager.class.getResource("scenes/list_of_programs.fxml"));
        try {
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);
        stage.setTitle("List of programs");
        stage.initOwner(WindowsManager.stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        controller = loader.getController();
    }
    public static ListOfProgramsController getController() {
        return controller;
    }

    public static void show(){
        controller.reload();
        stage.show();
    }

    public static void close(){
        stage.close();
    }
}
