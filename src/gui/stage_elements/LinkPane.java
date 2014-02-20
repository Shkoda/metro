package gui.stage_elements;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


import static gui.config.Config.*;

/**
 * Created by Nightingale on 16.02.14.
 */
public class LinkPane {


    public static Pane createLinkPane() {
        AnchorPane root = new AnchorPane();
        AnchorPane.setBottomAnchor(root, ANCHOR_OFFSET_WORK_AREA);
        root.setStyle("-fx-background-color: #33f46c;-fx-border-color: #b03c5d; ");


        GridPane gridForLinks = new GridPane();
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


        Button editProcessorsButton = new Button();
        editProcessorsButton.setId("EditProcessorLinkButton");


        Button editTaskButton = new Button();
        editTaskButton.setId("EditTasksLinkButton");

        Button modellerButton = new Button();
        modellerButton.setId("ModellingLinkButton");

        Button statisticsButton = new Button();
        statisticsButton.setId("StatisticsLinkButton");

        GridPane.setHalignment(editProcessorsButton, HPos.CENTER);
        GridPane.setHalignment(editTaskButton, HPos.CENTER);
        GridPane.setHalignment(modellerButton, HPos.CENTER);
        GridPane.setHalignment(statisticsButton, HPos.CENTER);

        gridForLinks.add(editProcessorsButton, 0, 0);
        gridForLinks.add(editTaskButton, 1, 0);
        gridForLinks.add(modellerButton, 0, 1);
        gridForLinks.add(statisticsButton, 1, 1);

        gridForLinks.prefHeightProperty().bind(root.heightProperty());
        gridForLinks.prefWidthProperty().bind(root.widthProperty());
        root.getChildren().setAll(gridForLinks);


        return root;
    }
}
