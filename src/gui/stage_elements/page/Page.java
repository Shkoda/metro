package gui.stage_elements.page;

import gui.Main;
import gui.config.Config;
import gui.stage_elements.workarea.WorkPane;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by Nightingale on 20.02.14.
 */
public class Page {
    public final String name;
    private GridPane template;
    private WorkPane workPane;

    public Page(String name) {
        this.name = name;
        template = PageTemplateCreator.get(name);    //todo remove emp code
    }

    public void addBackButton(){
        Button backButton = PageTemplateCreator.createButton("BackButton", Config.SYSTEM_MENU_BUTTON_SIZE);
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Main.goTo(Main.pageHolder.START_PAGE);
            }
        });
        template.add(backButton, 0, 0);
    }

    public void addNavigationButton(final Page goToPage, boolean isNextPage){
        String fxId = isNextPage ? "NextButton": "PreviousButton";
        Button button = PageTemplateCreator.createButton(fxId,  Config.PREVIOUS_NEXT_BUTTON_SIZE);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Main.goTo(goToPage);
            }
        });
        int column = isNextPage ? 2 : 0;
        template.add(button, column, 1);
    }



    public void setWorkPane(WorkPane workArea) {
        this.workPane = workArea;
        template.add(workArea.getRoot(), 1,1);
    }

    public GridPane getTemplate() {
        return template;
    }
}
