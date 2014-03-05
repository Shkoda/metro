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

    protected ToggleButton cursorButton;
    protected ToggleButton addButton;
    protected ToggleButton linkButton;
    protected Button checkButton;


    public EditorPane(String cursorButtonId, String addButtonId, String linkButtonId, String checkButtonId) {
        root = new GridPane();
        setConstraints();
        addToolBar(cursorButtonId, addButtonId, linkButtonId, checkButtonId);
        addCanvasContainer();
        root.setGridLinesVisible(true);
        newCanvas();
    }


    public void newCanvas() {
        canvasContainer.setContent(new Canvas(this).get());
    }

    private void addCanvasContainer() {
        canvasContainer = new ScrollPane();
        canvasContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        canvasContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.add(canvasContainer, 0, 2);

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
