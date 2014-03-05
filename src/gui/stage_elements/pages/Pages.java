package gui.stage_elements.pages;

import gui.stage_elements.pages.template.workarea.EditorPane;
import gui.stage_elements.pages.template.workarea.ModellerPane;
import gui.stage_elements.pages.template.workarea.StartPagePane;
import gui.stage_elements.pages.template.workarea.StatisticsPane;

/**
 * Created by Nightingale on 02.03.14.
 */
public class Pages {
    public final PageNewEdition START_PAGE, EDIT_TASKS_PAGE,
            EDIT_MPP_PAGE, MODELLER_PAGE, STATISTICS_PAGE;


    public Pages() {
        START_PAGE = new PageNewEdition("Start Page");
        EDIT_TASKS_PAGE = new PageNewEdition("Edit MPP");
        EDIT_MPP_PAGE = new PageNewEdition("Edit Task Graph");
        MODELLER_PAGE = new PageNewEdition("Modeller");
        STATISTICS_PAGE = new PageNewEdition("Statistics");


    }

    public void init() {
        START_PAGE.setWorkPane(new StartPagePane());
        EDIT_TASKS_PAGE.setWorkPane(new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"));
        EDIT_MPP_PAGE.setWorkPane(new EditorPane("CursorButton", "AddProcessorButton", "LinkButton", "CheckButton"));
        MODELLER_PAGE.setWorkPane(new ModellerPane());
        STATISTICS_PAGE.setWorkPane(new StatisticsPane());

        EDIT_TASKS_PAGE.addBackButton();
        EDIT_MPP_PAGE.addBackButton();
        MODELLER_PAGE.addBackButton();
        STATISTICS_PAGE.addBackButton();
    }


}























