package gui.stage_elements.page;

import gui.stage_elements.workarea.*;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Nightingale on 02.03.14.
 */
public class PageHolder {
    public final Page START_PAGE, EDIT_TASKS_PAGE,
            EDIT_MPP_PAGE, MODELLER_PAGE, STATISTICS_PAGE;


    public PageHolder() {
        START_PAGE = new Page("Start Page");
        EDIT_TASKS_PAGE = new Page("Edit MPP");
        EDIT_MPP_PAGE = new Page("Edit Task Graph");
        MODELLER_PAGE = new Page("Modeller");
        STATISTICS_PAGE = new Page("Statistics");
    }

    public void init( AnchorPane root) {
        ReadOnlyDoubleProperty rootWidthProperty = root.widthProperty();
        ReadOnlyDoubleProperty rootHeightProperty = root.heightProperty();

        initPage(START_PAGE, new StartPagePane(), false, rootWidthProperty, rootHeightProperty );
        initPage(EDIT_TASKS_PAGE, new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"), true, rootWidthProperty, rootHeightProperty );
        initPage(EDIT_MPP_PAGE, new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"), true, rootWidthProperty, rootHeightProperty );
        initPage(MODELLER_PAGE, new ModellerPane(), true, rootWidthProperty, rootHeightProperty );
        initPage(STATISTICS_PAGE, new StatisticsPane(), true, rootWidthProperty, rootHeightProperty );
    }

    private void initPage(Page page, WorkPane workPane, boolean addBackButton, ReadOnlyDoubleProperty rootWidthProperty,  ReadOnlyDoubleProperty rootHeightProperty){
        page.setWorkPane(workPane);
        page.getTemplate().minWidthProperty().bind(rootWidthProperty);
        page.getTemplate().minHeightProperty().bind(rootHeightProperty);
        if (addBackButton)
            page.addBackButton();
    }
}























