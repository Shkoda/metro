package gui.stage_elements.editor_elements;

import gui.Main;
import gui.config.Config;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nightingale on 05.03.14.
 */
public class ProcessorElement extends EditorElement {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private String name;
    private Group group;

    public ProcessorElement() {
        name = "P" + counter.incrementAndGet();

        final Shape rectangle = new Rectangle(0, 0, Config.PROCESSOR_ELEMENT_WIDTH, Config.PROCESSOR_ELEMENT_WIDTH);
        group = new Group();

        group.getChildren().addAll(rectangle, new Text(Config.PROCESSOR_ELEMENT_WIDTH - 5, Config.PROCESSOR_ELEMENT_HEIGHT + 10, name));
        rectangle.setFill(new ImagePattern(new Image(Main.class.getResourceAsStream("image/elements/processor.png"))));
        group.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                rectangle.setEffect(new Lighting());
                ((Node) me.getSource()).setCursor(Cursor.HAND);
            }
        });


        group.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                rectangle.setEffect(null);
                ((Node) me.getSource()).setCursor(Cursor.DEFAULT);
            }
        });

    }

    @Override
    public Group getDrawable() {
        return group;
    }
}
