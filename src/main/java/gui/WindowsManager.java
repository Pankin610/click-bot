package gui;

import files.CreatedPrograms;
import gui.applications.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controllers should use methods from this class to interfere other windows (this is much safer).
 * This class also contains components of main window of the program:
 * Main BorderPane (root) and main Stage (stage) [so far].
 */

public class WindowsManager {
    public static Stage stage;
    public static BorderPane root;
    static {
        try {
            root = FXMLLoader.load(WindowsManager.class.getResource("scenes/main.fxml"));
            root.setCenter(StartWindow.getPane());
            ProgramMenu.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    /**
     * Closing main Window of the Program (should stop whole program).
     */
    public static void closeProgram(){
        stage.close();
    }

    /**
     * Change actual scene inside main window. Before calling this method scenes should be prepared, reloaded, etc.
     * @param type of scene.
     */
    public static void changeScene(SceneType type){
        ProgramMenu.settingScene(type);
        if(type == SceneType.PROJECT_SCENE) root.setCenter(ProjectWindow.getPane());
        if(type == SceneType.START_SCENE)   root.setCenter(StartWindow.getPane());
    }

    /**
     * Show window with list of created programs.
     */
    public static void showListOfProgram() {
        ListOfProgramsWindow.show();
    }

    /**
     * Open project window with existing project.
     * @param name of existing project.
     */
    public static void openExistingProject(String name) {
        ProjectWindow.prepareExisting(CreatedPrograms.getFileByName(name));
        changeScene(SceneType.PROJECT_SCENE);
    }

    /**
     * Open dialog for name of new project.
     */
    public static void openNewDialog(){
        ProgramNameWindow.show();
    }

    /**
     * Open project window with empty project with given name.
     * @param name of project.
     */
    public static void openNewProject(String name){
        ProjectWindow.prepareNew(name);
        changeScene(SceneType.PROJECT_SCENE);
    }

    public static void showAboutWindow() {
        AboutWindow.show();
    }
}
