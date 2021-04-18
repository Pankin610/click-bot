package gui.applications;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

/**
 * This class is responsible for handling error-message windows.
 */
public abstract class ErrorAlert {
    public static void showErrorAlert(String message, Stage owner){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setContentText(message);
        Toolkit.getDefaultToolkit().beep();
        alert.show();
    }
}
