package gui.controllers;

import javafx.fxml.Initializable;

/**
 * Every Controller should implements this interface.
 */

public interface Controller extends Initializable {
    /**
     * This method should be called before showing the scene,
     * if something should be actualized due to changed state of data.
     */
    void reload();
}
