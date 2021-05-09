package gui.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TreeTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final StackPane stackPane = new StackPane();

        TreeItem<Integer> root = createTreeItem(1);

        final TreeView<Integer> tree = new TreeView<>(root);
        tree.setCellFactory(treeView -> {
            final Label label = new Label();
            final Label anotherLabel = new Label("Item:");
            label.getStyleClass().add("highlight-on-hover");
            final HBox hbox = new HBox(5, anotherLabel, label);
            TreeCell<Integer> cell =  new TreeCell<Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(hbox);
                    }
                }
            };
            cell.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            cell.itemProperty().addListener((obs, oldItem, newItem) ->
                    label.setText(newItem != null ? String.valueOf(newItem) : ""));
            return cell ;
        });
        stackPane.getChildren().add(tree);
        final Scene scene = new Scene(stackPane);

        scene.getStylesheets().add(getClass().getResource("tree-hover.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getSimpleName());
        primaryStage.show();
    }

    private TreeItem<Integer> createTreeItem(int value) {
        TreeItem<Integer> item = new TreeItem<>(value);
        if (value < 10000) {
            for (int i=0; i<10; i++) {
                item.getChildren().add(createTreeItem(10*value+i));
            }
        }
        return item ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}