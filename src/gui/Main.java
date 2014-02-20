package gui;

import gui.stage_elements.LinkPane;
import gui.stage_elements.pages.PageWithContent;
import gui.stage_elements.pages.template.PageBuilder;
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
    private PageWithContent currentPage;
    private Node currentPageView;
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

        Pane linkPane = LinkPane.createLinkPane();

        GridPane gridPane = PageBuilder.createEmptyTemplate();
        PageBuilder.addBackButton(gridPane);
        PageBuilder.setPageName(gridPane, "Start Page");
        PageBuilder.addWorkArea(gridPane, linkPane);
        PageBuilder.addSettingsButton(gridPane);

        gridPane.minWidthProperty().bind(root.widthProperty());
        gridPane.minHeightProperty().bind(root.heightProperty());

        root.getChildren().setAll(gridPane);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT, true);
        stage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("JMetroLightTheme.css").toExternalForm());

        stage.show();

    }

    public void goToPage(PageWithContent page) {
        Node view = page.createView();
        if (view == null) view = new Region();
        pageArea.getChildren().setAll(view);
        currentPageView = view;
        currentPage = page;
    }
}
