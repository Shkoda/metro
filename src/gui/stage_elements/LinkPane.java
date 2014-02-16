package gui.stage_elements;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;


import static gui.config.Config.*;
/**
 * Created by Nightingale on 16.02.14.
 */
public class LinkPane  {

    public static TilePane createLinkPane(){
        TilePane linkPane = new TilePane(Orientation.HORIZONTAL, DISTANCE_BETWEEN_LINKS, DISTANCE_BETWEEN_LINKS);

        AnchorPane.setTopAnchor(linkPane, ANCHOR_OFFSET_FOR_LINK_PANE);
        AnchorPane.setRightAnchor(linkPane, ANCHOR_OFFSET_FOR_LINK_PANE);
        AnchorPane.setBottomAnchor(linkPane, ANCHOR_OFFSET_FOR_LINK_PANE);
        AnchorPane.setLeftAnchor(linkPane, ANCHOR_OFFSET_FOR_LINK_PANE);


        linkPane.setPrefColumns(3);


        Button fileButton = new Button();
        fileButton.setId("FileLinkButton");

        Button editProcessorsButton = new Button();
        editProcessorsButton.setId("EditProcessorLinkButton");

        Button editTaskButton = new Button();
        editTaskButton.setId("EditTasksLinkButton");

        Button modellerButton = new Button();
        modellerButton.setId("ModellingLinkButton");

        Button statisticsButton = new Button();
        statisticsButton.setId("StatisticsLinkButton");

        Button settingsButton = new Button();
        settingsButton.setId("SettingsLinkButton");


        linkPane.getChildren().addAll(fileButton, editProcessorsButton, editTaskButton, modellerButton, statisticsButton, settingsButton);

        return linkPane;
    }
}
