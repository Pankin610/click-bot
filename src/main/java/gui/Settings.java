package gui;

import files.reading.ReadFileObject;
import gui.controllers.SettingsController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public abstract class Settings {
    private static int DELAY;
    private static final String PATH = "src/main/java/gui/settings.txt";

    public static int getDelay() {
        return DELAY;
    }

    public static void load(SettingsController controller){
        DELAY = controller.DELAY;
        save();
    }

    public static void load(){
        Scanner scanner = new ReadFileObject(PATH).getScanner();
        scanner.next();
        DELAY = Integer.parseInt(scanner.next());
    }

    private static void save(){
        try {
            FileOutputStream file = new FileOutputStream(PATH);
            file.write(("DELAY: " + DELAY).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(){
        System.out.println("---SETTINGS---");
        System.out.println("DELAY: " + DELAY);
        System.out.println("--------------");
    }
}
