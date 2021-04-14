package gui.applications;

import gui.WindowsManager;
import gui.controllers.MenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;

import java.io.IOException;

public class ProgramMenu implements SideWindow {
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
        WindowsManager.root.setTop(menu);
    }

    public static void init(){} /* used to load static initialization */

    public static void settingProjectScene(){
        controller.setActiveProject(true);
    }

    public static void settingStartScene(){
        controller.setActiveProject(false);
    }
}
