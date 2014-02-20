package gui.stage_elements.pages.template;

import gui.Main;
import gui.config.Config;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import static gui.config.Config.ANCHOR_OFFSET_WORK_AREA;
import static gui.config.Config.SYSTEM_MENU_BUTTON_SIZE;

/**
 * Created by Nightingale on 17.02.14.
 */
public class PageBuilder {

    public static GridPane createEmptyTemplate() {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #f2f437;-fx-border-color: #fa0d8d; ");

        setAnchors(gridPane);

        ColumnConstraints leftConstraint = new ColumnConstraints();
        setConstantWidth(leftConstraint, Config.SYSTEM_MENU_BUTTON_SIZE);

        ColumnConstraints rightConstraint = new ColumnConstraints();
        setConstantWidth(rightConstraint, SYSTEM_MENU_BUTTON_SIZE);

        ColumnConstraints contentColumn = new ColumnConstraints();
        contentColumn.prefWidthProperty().bind(gridPane.widthProperty());

        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().setAll(leftConstraint, contentColumn, rightConstraint);

        RowConstraints headerRow = new RowConstraints();
        setConstantHeight(headerRow, SYSTEM_MENU_BUTTON_SIZE);

        RowConstraints contentRow = new RowConstraints();
        contentRow.prefHeightProperty().bind(gridPane.heightProperty());

        gridPane.getRowConstraints().setAll(headerRow, contentRow);

        return gridPane;
    }

    public static GridPane setPageName(GridPane template, String name) {
        template.add(new Label(name), 1, 0);
        return template;
    }

    public static GridPane addBackButton(GridPane template) {
        Button backButton =createButton("BackButton", 20);
        template.add(backButton, 0, 0);
        return template;
    }

    public static GridPane addSettingsButton(GridPane template) {
        Button settingsButton = createButton("SettingsButton", 20);
        template.add(settingsButton, 2, 0);
        return template;
    }

    private static Button createButton(String fxId, int size) {
        Button backButton = new Button();

        backButton.setMinSize(size, size);
        backButton.setPrefSize(size, size);

        backButton.setId(fxId);
        GridPane.setHalignment(backButton, HPos.CENTER);
        return backButton;
    }

    public static GridPane addWorkArea(GridPane template, Pane workArea) {
        AnchorPane.setBottomAnchor(workArea, ANCHOR_OFFSET_WORK_AREA);
        workArea.prefWidthProperty().bind(template.getColumnConstraints().get(1).prefWidthProperty());
        workArea.prefHeightProperty().bind(template.getRowConstraints().get(1).prefHeightProperty());
        template.add(workArea, 1, 1);
        return template;
    }


    private static void setAnchors(GridPane gridPane) {
        AnchorPane.setTopAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setRightAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setBottomAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setLeftAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
    }

    private static void setConstantWidth(ColumnConstraints columnConstraints, int size) {
        columnConstraints.setMaxWidth(size);
        columnConstraints.setMinWidth(size);
        columnConstraints.setPrefWidth(size);
    }


    private static void setConstantHeight(RowConstraints rowConstraints, int size) {
        rowConstraints.setMinHeight(size);
        rowConstraints.setPrefHeight(size);
        rowConstraints.setMaxHeight(size);
    }
}
