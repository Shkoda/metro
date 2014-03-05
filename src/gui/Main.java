package gui;

import gui.stage_elements.pages.PageNewEdition;
import gui.stage_elements.pages.Pages;
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

    private Pane pageArea;

    private Node currentPageView;
    private static Stage stage;
    private static AnchorPane root;

    public static Pages pages = new Pages();
    static {
        pages.init();
    }

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

//        PageTemplate pageTemplate = new PageTemplate("Start Page");
//        //   pageTemplate.setWorkPane(new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"));
//        pageTemplate.setWorkPane(new StartPagePane());
//        GridPane gridPane = pageTemplate.getTemplate();
//
//
//        gridPane.minWidthProperty().bind(root.widthProperty());
//        gridPane.minHeightProperty().bind(root.heightProperty());
//
//        root.getChildren().setAll(gridPane);


        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, true);
        stage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("JMetroLightTheme.css").toExternalForm());

        goTo(pages.START_PAGE);
        stage.show();

    }

    public static void goTo(PageNewEdition pageTemplate) {
        GridPane gridPane = pageTemplate.getTemplate();

        gridPane.minWidthProperty().bind(root.widthProperty());
        gridPane.minHeightProperty().bind(root.heightProperty());

        root.getChildren().setAll(gridPane);
    }


}
