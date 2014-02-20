package gui.stage_elements.pages.content;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

/**
 * Created by Nightingale on 16.02.14.
 */
public abstract class AbstractPage extends Pane {
    private String name;


    @Override
    protected void layoutChildren() {

        List<Node> managed = getManagedChildren();

        double width = getWidth();
        double height = getHeight();

        double top = getInsets().getTop();
        double right = getInsets().getRight();
        double left = getInsets().getLeft();
        double bottom = getInsets().getBottom();
        for (Node child : managed) {
            layoutInArea(child, left, top,
                    width - left - right, height - top - bottom,
                    0, Insets.EMPTY, true, true, HPos.CENTER, VPos.CENTER);
        }

    }


    public String getName() {
        return name;
    }
}
