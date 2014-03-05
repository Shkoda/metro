package gui.stage_elements.workarea;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by Nightingale on 02.03.14.
 */
public class ModellerPane extends WorkPane {
    @Override
    public Pane getRoot() {
        BorderPane tem = new BorderPane();
        tem.setCenter(new Label("Modeller WorkPane"));
        return tem;
    }


}
