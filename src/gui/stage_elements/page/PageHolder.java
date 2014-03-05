package gui.stage_elements.page;

import data.DataHolder;
import gui.stage_elements.workarea.*;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nightingale on 02.03.14.
 */
public class PageHolder {
    public final Page START_PAGE, EDIT_TASKS_PAGE,
            EDIT_MPP_PAGE, MODELLER_PAGE, STATISTICS_PAGE;

    private List<Page> pageSequence;


    public PageHolder(DataHolder dataHolder, Stage stage) {
        START_PAGE = new Page("Start Page", dataHolder, stage);
        EDIT_TASKS_PAGE = new Page("Edit MPP", dataHolder, stage);
        EDIT_MPP_PAGE = new Page("Edit Task Graph", dataHolder, stage);
        MODELLER_PAGE = new Page("Modeller", dataHolder, stage);
        STATISTICS_PAGE = new Page("Statistics", dataHolder, stage);

        pageSequence = Arrays.asList(START_PAGE, EDIT_MPP_PAGE, EDIT_TASKS_PAGE, MODELLER_PAGE, STATISTICS_PAGE);
    }

    public void init(AnchorPane root) {
        ReadOnlyDoubleProperty rootWidthProperty = root.widthProperty();
        ReadOnlyDoubleProperty rootHeightProperty = root.heightProperty();

        initPage(START_PAGE, new StartPagePane(), false, rootWidthProperty, rootHeightProperty);
        initPage(EDIT_TASKS_PAGE, new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"), true, rootWidthProperty, rootHeightProperty);
        initPage(EDIT_MPP_PAGE, new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"), true, rootWidthProperty, rootHeightProperty);
        initPage(MODELLER_PAGE, new ModellerPane(), true, rootWidthProperty, rootHeightProperty);
        initPage(STATISTICS_PAGE, new StatisticsPane(), true, rootWidthProperty, rootHeightProperty);

        addPreviousAndNextButtons();
    }

    private void initPage(Page page, WorkPane workPane, boolean addBackButton, ReadOnlyDoubleProperty rootWidthProperty, ReadOnlyDoubleProperty rootHeightProperty) {
        page.setWorkPane(workPane);
        page.getTemplate().minWidthProperty().bind(rootWidthProperty);
        page.getTemplate().minHeightProperty().bind(rootHeightProperty);
        if (addBackButton)
            page.addBackButton();
    }

    private void addPreviousAndNextButtons() {
        int size = pageSequence.size();
        for (int i = 1; i < size; i++) {
            Page current = pageSequence.get(i);
            current.addNavigationButton(pageSequence.get(i - 1), false);
            current.addNavigationButton(pageSequence.get((i + 1) % size), true);
        }
    }
}























