package gui.stage_elements.pages;

import gui.config.Config;
import gui.stage_elements.pages.content.AbstractPage;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Created by Nightingale on 16.02.14.
 */
public class PageWithContent {
    private AbstractPage content;

    public PageWithContent(AbstractPage content) {
        this.content = content;
    }

    public Node createView() {

        final VBox main = new VBox(8);
        Label header = new Label(content.getName());

        main.getChildren().add(header);
        // create abstractPageContent area
        final StackPane sampleArea = new StackPane();
        VBox.setVgrow(sampleArea, Priority.SOMETIMES);
        main.getChildren().add(sampleArea);
        // create abstractPageContent
        //  final AbstractPageContent abstractPageContent =pageContent;// (AbstractPageContent) contentClass.newInstance();
        sampleArea.getChildren().add(content);
        // create abstractPageContent controls

        // create border pane for main content and sidebar
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(main);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setContent(borderPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setMinWidth(Config.SCENE_WIDTH);
        scrollPane.setMinHeight(Config.SCENE_HEIGHT);

        return scrollPane;

    }
}
