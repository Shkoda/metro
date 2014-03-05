package gui.stage_elements.pages;

import gui.Main;
import gui.config.Config;
import gui.stage_elements.pages.template.PageTemplateCreator;
import gui.stage_elements.pages.template.workarea.WorkPane;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by Nightingale on 20.02.14.
 */
public class PageNewEdition {
    public final String name;
    private GridPane template;
    private WorkPane workPane;

    public PageNewEdition(String name) {
        this.name = name;
        template = PageTemplateCreator.get(name, name.equals("Start Page"));    //todo remove temp code
    }

    public void addBackButton(){
        Button backButton = PageTemplateCreator.createButton("BackButton", Config.SYSTEM_MENU_BUTTON_SIZE);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Main.goTo(Main.pages.START_PAGE);
            }
        });
        template.add(backButton, 0, 0);
    }

    public void setWorkPane(WorkPane workArea) {
        this.workPane = workArea;
        template.add(workArea.getRoot(), 1,1);
    }

    public GridPane getTemplate() {
        return template;
    }
}
