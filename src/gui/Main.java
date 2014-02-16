package gui;

import gui.stage_elements.LinkPane;
import javafx.application.Application;
import javafx.scene.DepthTest;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.plugin.javascript.navig.Anchor;

import static gui.config.Config.*;

/**
 * Created by Nightingale on 16.02.14.
 */
public class Main extends Application {


    private Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Metro style");
        AnchorPane root = new AnchorPane();
        stage.setMinHeight(SCENE_HEIGHT);
        stage.setMinWidth(SCENE_WIDTH);

        TilePane linkPane = LinkPane.createLinkPane();
        root.getChildren().add(linkPane);


        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, true);
        stage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("JMetroLightTheme.css").toExternalForm());

        stage.show();

    }
}
