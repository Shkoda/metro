package gui.stage_elements.pages.content;

import gui.Main;
import gui.stage_elements.LinkPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import static gui.config.Config.ANCHOR_OFFSET_WORK_AREA;


/**
 * Created by Nightingale on 16.02.14.
 */
public class StartPage extends AbstractPage {

    public StartPage() {

        BorderPane root = new BorderPane();

        BorderPane header = new BorderPane();
  //     header.setSpacing(200);
        Label pageName = new Label("Start page");

        AnchorPane.setRightAnchor(pageName, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setLeftAnchor(pageName, ANCHOR_OFFSET_WORK_AREA);

        AnchorPane nameContainer = new AnchorPane();
        nameContainer.getChildren().setAll(pageName);

        Button menuButton = new Button();



        AnchorPane.setRightAnchor(menuButton, ANCHOR_OFFSET_WORK_AREA);
        AnchorPane.setLeftAnchor(menuButton, ANCHOR_OFFSET_WORK_AREA);

        AnchorPane buttonPane = new AnchorPane();
        buttonPane.getChildren().add(menuButton);

        Label other = new Label("hoy");
        other.setAlignment(Pos.BOTTOM_RIGHT);


        ImageView imageView = new ImageView(new Image(Main.class.getResourceAsStream("image/menu/menu2.png")));
//        imageView.setFitHeight(20);
//        imageView.setFitWidth(20);

//        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        menuButton.setGraphic(imageView);
        //   menuButton.setId("MenuButton");
        //    menuButton.setPrefHeight(20);
        //     menuButton.setPrefWidth(20);

//        header.getChildren().addAll(nameContainer, other);
        header.setLeft(nameContainer);
        header.setRight(menuButton);

        AnchorPane centralPane = new AnchorPane();
        centralPane.getChildren().setAll(LinkPane.createLinkPane());

        root.setTop(header);
        root.setCenter(centralPane);


        getChildren().add(root);
    }
}
