package gui;

import data.DataHolder;
import gui.stage_elements.page.Page;
import gui.stage_elements.page.PageHolder;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static gui.config.Config.*;

/**
 * Created by Nightingale on 16.02.14.
 */
public class Main extends Application {
    private static Stage stage;
    private static AnchorPane root;
    private DataHolder dataHolder;

    public static  PageHolder pageHolder ;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        stage.setTitle("Metro style");
        root = new AnchorPane();

        stage.setMinHeight(SCENE_HEIGHT);
        stage.setMinWidth(SCENE_WIDTH);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, true);
        stage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("JMetroLightTheme.css").toExternalForm());

        dataHolder = new DataHolder();
        pageHolder = new PageHolder(dataHolder, stage);
        pageHolder.init(root);

        goTo(pageHolder.START_PAGE);
        stage.show();
    }

    public static void goTo(Page pageTemplate) {
        root.getChildren().setAll(pageTemplate.getTemplate());
    }
}
