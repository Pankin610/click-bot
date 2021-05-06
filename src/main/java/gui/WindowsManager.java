package gui;

import files.CreatedPrograms;
import gui.applications.ListOfProgramsWindow;
import gui.applications.ProgramMenu;
import gui.applications.ProgramNameWindow;
import gui.applications.StartWindow;
import gui.applications.features.AboutWindow;
import gui.applications.features.SettingsWindow;
import gui.applications.projecting.AddVariableWindow;
import gui.applications.projecting.ProjectWindow;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.Coordinate;
import util.containers.VariableContainer;
import util.gui.MouseUtility;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

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
     * Changes actual scene inside main window. Before calling this method scenes should be prepared, reloaded, etc.
     * @param type of scene.
     */
    public static void changeScene(SceneType type){
        ProgramMenu.settingScene(type);
        if(type == SceneType.PROJECT_SCENE) root.setCenter(ProjectWindow.getPane());
        if(type == SceneType.START_SCENE)   root.setCenter(StartWindow.getPane());
    }

    /**
     * Shows window with list of created programs.
     */
    public static void showListOfProgram() {
        ListOfProgramsWindow.show();
    }

    /**
     * Opens project window with existing project.
     * @param name of existing project.
     */
    public static void openExistingProject(String name) {
        ProjectWindow.prepareExisting(CreatedPrograms.getFileByName(name));
        changeScene(SceneType.PROJECT_SCENE);
    }

    /**
     * Opens dialog for name of new project.
     */
    public static void openNewDialog(){
        ProgramNameWindow.reload();
        ProgramNameWindow.show();
    }

    /**
     * Opens project window with empty project with given name.
     * @param name of project.
     */
    public static void openNewProject(String name){
        ProjectWindow.prepareNew(name);
        changeScene(SceneType.PROJECT_SCENE);
    }

    /**
     * Shows window with information about project.
     */
    public static void showAboutWindow() {
        AboutWindow.show();
    }

    /**
     * @return {@code TreeItem} with current project.
     */
    public static TreeItem<String> getRootOfProject(){
        return ProjectWindow.getController().programTree.getRoot();
    }

    /**
     * Self-explaining.
     */
    public static void showSettingsWindow() {
        SettingsWindow.show();
    }

    public static VariableContainer getProjectVariables() {
        return ProjectWindow.getController().getVariables();
    }

    public static FXMLLoader getLoader(String file) {
        return new FXMLLoader(WindowsManager.class.getResource("scenes/" + file + ".fxml"));
    }

    //TODO clear up this mess

    public static Color getPixelColor(){
        final AtomicReference<Color> res = new AtomicReference<>(new Color(0));
        final Stage n_stage = new Stage();
        n_stage.setTitle("Press Q to get color");
        final AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(1);
        pane.setPrefHeight(1);
        final Scene scene = new Scene(pane);
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            synchronized public void handle(KeyEvent keyEvent) {
                System.out.println(keyEvent.getCode());
                if (keyEvent.getCode() == KeyCode.Q) {
                    res.set(MouseUtility.getColor());
                    n_stage.close();
                }
            }
        });
        n_stage.setScene(scene);
        n_stage.initModality(Modality.APPLICATION_MODAL);
        n_stage.initOwner(stage);
        n_stage.showAndWait();
        return res.get();
    }

    public static Coordinate getCords(){
        final AtomicReference<Coordinate> res = new AtomicReference<>(new Coordinate(0,0));
        final Stage n_stage = new Stage();
        n_stage.setTitle("Press Q to get cords");
        final AnchorPane pane = new AnchorPane();
        pane.setPrefWidth(1);
        pane.setPrefHeight(1);
        final Scene scene = new Scene(pane);
        scene.setOnKeyPressed(new EventHandler<>() {
            @Override
            synchronized public void handle(KeyEvent keyEvent) {
                System.out.println(keyEvent.getCode());
                if (keyEvent.getCode() == KeyCode.Q) {
                    res.set(MouseUtility.getCords());
                    n_stage.close();
                }
            }
        });
        n_stage.setScene(scene);
        n_stage.initModality(Modality.APPLICATION_MODAL);
        n_stage.initOwner(stage);
        n_stage.showAndWait();
        return res.get();
    }

    public static void addVariable(){
        AddVariableWindow.show();
    }
}
