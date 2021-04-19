package gui.applications;

import gui.SceneType;
import gui.WindowsManager;
import gui.controllers.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import java.io.IOException;

/**
 * Class representing menu bar visible on the main window.
 */
public abstract class ProgramMenu implements SideWindow {
    private final static MenuController controller;
    private final static MenuBar menu;
    static{
        FXMLLoader loader = new FXMLLoader(WindowsManager.class.getResource("scenes/menu.fxml"));
        MenuBar tmp = null;
        try {
            tmp = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menu = tmp;
        controller = loader.getController();
        controller.saveItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        WindowsManager.root.setTop(menu);
    }

    public static void init(){} /* used to load static initialization */

    /**
     * Use whenever Scene is changed.
     */
    public static void settingScene(SceneType type){
        controller.setActiveProject(type == SceneType.PROJECT_SCENE);
    }
}
