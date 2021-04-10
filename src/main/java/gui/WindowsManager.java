package gui;

import gui.applications.AboutWindow;
import gui.applications.ProjectWindow;
import gui.applications.SideWindow;
import gui.applications.StartWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * THIS is total MESS so far. I am just trying to figure out how to manage it.
 * That's not final logic of that part of program.
 */

public class WindowsManager {
    public static Stage stage;
    public static BorderPane root;
    public static MenuBar menu;

    /**
     * This method should be called only once, at start of application Main (stage is primary stage of program).
     */
    public static void setStage(Stage stage) {
        WindowsManager.stage = stage;
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Click-Bot");
    }

    /**
     * Starting main Window of the program.
     */
    public static void startProgram(){
        stage.show();
    }

    public static void closeProgram(){
        stage.close();
    }

    static {
        try {
            menu = FXMLLoader.load(WindowsManager.class.getResource("scenes/menu.fxml"));
            root = FXMLLoader.load(WindowsManager.class.getResource("scenes/main.fxml"));
            root.setTop(WindowsManager.menu);
            root.setCenter(StartWindow.getPane());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}