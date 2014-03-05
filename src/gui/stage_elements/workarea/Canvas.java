package gui.stage_elements.workarea;

import gui.config.Config;
import gui.stage_elements.editor_elements.ProcessorElement;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

/**
 * Created by Nightingale on 05.03.14.
 */
public class Canvas {

    private Pane canvas;
    private double initX;
    private double initY;
    private Point2D dragAnchor;

    private final int height, width;
    private final EditorPane owner;


    public Canvas(EditorPane owner) {
        this(Config.CANVAS_HEIGHT, Config.CANVAS_WIDTH, owner);
    }

    public Canvas(int height, int width, final EditorPane owner) {
        this.height = height;
        this.width = width;
        this.owner = owner;

        canvas = new Pane();
        Rectangle visibleCanvas = RectangleBuilder.create()
                .width(width).height(height)
                .fill(Color.AZURE)
                .stroke(Color.BLACK)
                .build();

        canvas.getChildren().setAll(visibleCanvas);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (owner.addButton.isSelected()) {
                    ProcessorElement processorElement = new ProcessorElement();

                    final Node node = processorElement.getDrawable();
                    node.setTranslateX(me.getX());
                    node.setTranslateY(me.getY());

                    node.setOnMousePressed(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {
                            //when mouse is pressed, store initial position
                            System.out.println("press");
                            initX = node.getTranslateX();
                            initY = node.getTranslateY();
                            dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());

                        }
                    });

                    node.setOnMouseDragged(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent me) {

                            double dragX = me.getSceneX() - dragAnchor.getX();
                            double dragY = me.getSceneY() - dragAnchor.getY();
                            //calculate new position of the circle
                            double newXPosition = initX + dragX;
                            double newYPosition = initY + dragY;
                            node.setTranslateX(newXPosition);
                            node.setTranslateY(newYPosition);

                        }
                    });
                    canvas.getChildren().add(node);
                }

            }
        });

    }

    public Pane get(){
        return canvas;
    }
}
