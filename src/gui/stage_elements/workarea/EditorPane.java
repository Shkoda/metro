package gui.stage_elements.workarea;

import gui.utils.Utils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

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
    private ScrollPane scrollPane;
    private Pane contentArea;


    public EditorPane(String cursorButtonId, String addButtonId, String linkButtonId, String checkButtonId) {
        root = new GridPane();
        setConstraints();
        addToolBar(cursorButtonId, addButtonId, linkButtonId, checkButtonId);

        root.setGridLinesVisible(true);

    }

    private void addToolBar(String cursorButtonId, String addButtonId, String linkButtonId, String checkButtonId) {
        BorderPane borderPane = new BorderPane();

        ToolBar toolBar = new ToolBar();
        toolBar.setStyle("-fx-background-color: #f4f20c;-fx-border-color: #2c96f3; ");


        HBox box = new HBox();
        box.setPadding(new Insets(8));
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);

        ToggleGroup toggleGroup = new ToggleGroup();

        ToggleButton cursorButton = createButton(cursorButtonId, toggleGroup);
        ToggleButton addButton = createButton(addButtonId, toggleGroup);
        ToggleButton linkButton = createButton(linkButtonId, toggleGroup);
        Button checkButton = createButton(checkButtonId);


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
