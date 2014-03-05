package gui.stage_elements.workarea;


import gui.stage_elements.editor_elements.ProcessorElement;
import gui.utils.Utils;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

import static gui.config.Config.STATUS_HEADER_HEIGHT;
import static gui.config.Config.TOOL_HEIGHT;

/**
 * Created by Nightingale on 20.02.14.
 */
public class EditorPane extends WorkPane {
    private static final String CURSOR_BUTTON_ID = "CursorButton";
    private static final String CHECK_BUTTON_ID = "CheckButton";

    private GridPane root;
    private ToolBar statusBar;
    private ScrollPane canvasContainer;
    private Pane contentArea;

    private ToggleButton cursorButton;
    private ToggleButton addButton;
    private ToggleButton linkButton;
    private Button checkButton;

    private Pane canvas;
    private double initX;
    private double initY;
    private Point2D dragAnchor;

    public EditorPane(String cursorButtonId, String addButtonId, String linkButtonId, String checkButtonId) {
        root = new GridPane();
        setConstraints();
        addToolBar(cursorButtonId, addButtonId, linkButtonId, checkButtonId);

        canvasContainer = new ScrollPane();
        canvasContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        canvasContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        root.setGridLinesVisible(true);
        newCanvas();
    }

    public void newCanvas() {


        root.add(canvasContainer, 0, 2);


        canvas = new Pane();
        Rectangle visibleCanvas = RectangleBuilder.create()
                .width(1000).height(1000)
                .fill(Color.AZURE)
                .stroke(Color.BLACK)
                .build();

        canvas.getChildren().setAll(visibleCanvas);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (addButton.isSelected()) {
                    ProcessorElement processorElement = new ProcessorElement();

                    final Node node = processorElement.getDrawable();
                    node.setTranslateX(me.getX());
                    node.setTranslateY(me.getY());

                    node.setOnMousePressed(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            //when mouse is pressed, store initial position
                            System.out.println("press");
                            initX = node.getTranslateX();
                            initY = node.getTranslateY();
                            dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());

                        }
                    });

                    node.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {

                            double dragX = me.getSceneX() - dragAnchor.getX();
                            double dragY = me.getSceneY() - dragAnchor.getY();
                            //calculate new position of the circle
                            double newXPosition = initX + dragX;
                            double newYPosition = initY + dragY;
                            node.setTranslateX(newXPosition);
                            node.setTranslateY(newYPosition);

                        }
                    });
                    canvas.getChildren().add(node);
                }

            }
        });


        //variables for storing initial position before drag of circle
        canvasContainer.setContent(canvas);
    }

    private void addToolBar(String cursorButtonId, String addButtonId, String linkButtonId, String checkButtonId) {
        BorderPane borderPane = new BorderPane();
        ToolBar toolBar = new ToolBar();

        HBox box = new HBox();
        box.setPadding(new Insets(8));
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);

        ToggleGroup toggleGroup = new ToggleGroup();

        cursorButton = createButton(cursorButtonId, toggleGroup);
        addButton = createButton(addButtonId, toggleGroup);
        linkButton = createButton(linkButtonId, toggleGroup);
        checkButton = createButton(checkButtonId);


        cursorButton.setSelected(true);

        box.getChildren().setAll(cursorButton, addButton, linkButton, checkButton);
        toolBar.getItems().addAll(box);
        borderPane.setCenter(box);

        root.add(borderPane, 0, 3);
    }

    private ToggleButton createButton(String buttonId, ToggleGroup group) {
        ToggleButton button = new ToggleButton();
        button.setId(buttonId);
        button.setPrefSize(40, 40);
        button.setMinSize(40, 40);
        button.setToggleGroup(group);
        return button;
    }


    private Button createButton(String buttonId) {
        Button button = new Button();
        button.setId(buttonId);
        button.setPrefSize(40, 40);
        button.setMinSize(40, 40);
        return button;
    }


    private void setConstraints() {
        RowConstraints offsetRow = new RowConstraints();
        Utils.setConstantHeight(offsetRow, STATUS_HEADER_HEIGHT);

        RowConstraints statusRow = new RowConstraints();
        Utils.setConstantHeight(statusRow, STATUS_HEADER_HEIGHT);

        RowConstraints contentRow = new RowConstraints();
        contentRow.prefHeightProperty().bind(root.heightProperty());

        RowConstraints toolRow = new RowConstraints();
        Utils.setConstantHeight(toolRow, TOOL_HEIGHT);

        root.getRowConstraints().setAll(offsetRow, statusRow, contentRow, toolRow);

        ColumnConstraints column = new ColumnConstraints();
        column.prefWidthProperty().bind(root.widthProperty());

        root.getColumnConstraints().setAll(column);
    }

    @Override
    public GridPane getRoot() {
        return root;
    }
}
