package util.gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Utility class, to communicate with clipboard
 */
public class ClipboardUtility {
    static private final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Set content of clipboard.
     * @param content to be put
     */
    public static void setContent(String content){
        clipboard.setContents(new StringSelection(content),null);
    }

    /**
     * Returns content of clipboard or empty String if error occurred
     * (for example, there is image inside clipboard)
     * @return content of clipboard
     */
    public static String getContent(){
        try {
            return (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
