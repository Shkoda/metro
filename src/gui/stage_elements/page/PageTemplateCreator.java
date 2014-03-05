package gui.stage_elements.page;

import data.DataHolder;
import gui.config.Config;
import gui.utils.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.lang3.SerializationUtils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static gui.config.Config.ANCHOR_OFFSET_WORK_AREA;
import static gui.config.Config.SYSTEM_MENU_BUTTON_SIZE;

/**
 * Created by Nightingale on 17.02.14.
 */
public class PageTemplateCreator {


    public static GridPane get(String name, DataHolder dataHolder, Stage stage) {
        GridPane gridPane = new GridPane();
        setAnchors(gridPane);
        setConstraints(gridPane);
        setPageName(gridPane, name);
        addSettingsButton(gridPane, dataHolder, stage);

        gridPane.setGridLinesVisible(true);

        return gridPane;
    }

    private static void setConstraints(GridPane template) {
        ColumnConstraints leftConstraint = new ColumnConstraints();
        Utils.setConstantWidth(leftConstraint, Config.SYSTEM_MENU_BUTTON_SIZE);

        ColumnConstraints rightConstraint = new ColumnConstraints();
        Utils.setConstantWidth(rightConstraint, SYSTEM_MENU_BUTTON_SIZE);

        ColumnConstraints contentColumn = new ColumnConstraints();
        contentColumn.prefWidthProperty().bind(template.widthProperty());

        template.getColumnConstraints().setAll(leftConstraint, contentColumn, rightConstraint);

        RowConstraints headerRow = new RowConstraints();
        Utils.setConstantHeight(headerRow, SYSTEM_MENU_BUTTON_SIZE);

        RowConstraints contentRow = new RowConstraints();
        contentRow.prefHeightProperty().bind(template.heightProperty());

        template.getRowConstraints().setAll(headerRow, contentRow);
    }

    private static void setPageName(GridPane template, String name) {
        template.add(new Label(name), 1, 0);
    }

    static {

    }

    private static void addSettingsButton(GridPane template, final DataHolder dataHolder, final Stage stage) {
        MenuButton settings = new MenuButton();
        settings.setId("SettingsButton");

//        MenuItem newMenu = new MenuItem("New...");
//        newMenu.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent t) {
//                dataHolder.reset();
//            }
//        });
//
//        MenuItem openMenu = new MenuItem("Open...");
//        openMenu.setOnAction(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent t) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.setTitle("Open File");
//                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pzcs project file", "*.pzcs"));
//                File file = fileChooser.showOpenDialog(null);
//
//                try {
//
//                    DataHolder dataHolderReaded = (DataHolder)SerializationUtils.deserialize(Files.readAllBytes(file.toPath()));
//                    System.out.println(dataHolderReaded);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

    //    settings.getItems().addAll(newMenu, openMenu, new MenuItem("Save..."));
        settings.getItems().addAll(Menu.getNewMenuItem(dataHolder), Menu.getOpenMenuItem(dataHolder), Menu.getSaveMenuItem(dataHolder));
        settings.setMinSize(Config.SYSTEM_MENU_BUTTON_SIZE, Config.SYSTEM_MENU_BUTTON_SIZE);
        settings.setPrefSize(Config.SYSTEM_MENU_BUTTON_SIZE, Config.SYSTEM_MENU_BUTTON_SIZE);
        GridPane.setHalignment(settings, HPos.CENTER);

        template.add(settings, 2, 0);
    }

    public static Button createButton(String fxId, int size) {
        Button button = new Button();

        button.setMinSize(size, size);
        button.setPrefSize(size, size);
        button.setMaxSize(size, size);

        button.setId(fxId);
        GridPane.setHalignment(button, HPos.CENTER);
        return button;
    }

    private static void setAnchors(GridPane gridPane) {
        AnchorPane.setTopAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setRightAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setBottomAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setLeftAnchor(gridPane, ANCHOR_OFFSET_WORK_AREA);
    }


}
