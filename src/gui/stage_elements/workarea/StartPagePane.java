package gui.stage_elements.workarea;

import gui.Main;
import gui.stage_elements.page.Page;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


import static gui.config.Config.*;

/**
 * Created by Nightingale on 16.02.14.
 */
public class StartPagePane extends WorkPane {
    private AnchorPane root;
    private GridPane gridForLinks;

    public StartPagePane() {
        root = new AnchorPane();
        AnchorPane.setBottomAnchor(root, ANCHOR_OFFSET_WORK_AREA);
        root.setStyle("-fx-background-color: #33f46c;-fx-border-color: #b03c5d; ");


        gridForLinks = new GridPane();
        ColumnConstraints firstColumn = new ColumnConstraints();
        firstColumn.setPercentWidth(50);
        ColumnConstraints secondColumn = new ColumnConstraints();
        secondColumn.setPercentWidth(50);

        RowConstraints firstRow = new RowConstraints();
        firstRow.setPercentHeight(50);
        RowConstraints secondRow = new RowConstraints();
        secondRow.setPercentHeight(50);

        gridForLinks.getColumnConstraints().addAll(firstColumn, secondColumn);
        gridForLinks.getRowConstraints().addAll(firstRow, secondRow);

        gridForLinks.setStyle("-fx-background-color: #daf4cd;-fx-border-color: #b03c5d; ");
        gridForLinks.setGridLinesVisible(true);

        gridForLinks.prefHeightProperty().bind(root.heightProperty());
        gridForLinks.prefWidthProperty().bind(root.widthProperty());

        addLinkButtons();

        root.getChildren().setAll(gridForLinks);
    }

    private Button createButton(String fxId, final Page goToPage) {
        Button button = new Button();
        button.setId(fxId);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Main.goTo(goToPage);
            }
        });
        return button;
    }

    private void addLinkButtons() {

        Button editProcessorsButton = createButton("EditProcessorLinkButton", Main.pageHolder.EDIT_MPP_PAGE);
        Button editTaskButton = createButton("EditTasksLinkButton", Main.pageHolder.EDIT_TASKS_PAGE);
        Button modellerButton = createButton("ModellingLinkButton", Main.pageHolder.MODELLER_PAGE);
        Button statisticsButton = createButton("StatisticsLinkButton", Main.pageHolder.STATISTICS_PAGE);


        GridPane.setHalignment(editProcessorsButton, HPos.CENTER);
        GridPane.setHalignment(editTaskButton, HPos.CENTER);
        GridPane.setHalignment(modellerButton, HPos.CENTER);
        GridPane.setHalignment(statisticsButton, HPos.CENTER);

        gridForLinks.add(editProcessorsButton, 0, 0);
        gridForLinks.add(editTaskButton, 1, 0);
        gridForLinks.add(modellerButton, 0, 1);
        gridForLinks.add(statisticsButton, 1, 1);
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
