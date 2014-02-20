/*
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gui.stage_elements.pages.content;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;


public class EditTaskGraphPage extends AbstractPage {
    private static final int DEFAULT_RADIUS = 30;
    private static final int DRAW_AREA_WIDTH = 700;
    private static final int DRAW_AREA_HEIGHT = 400;


    final ToggleButton drawButton;


    //create a rectangle - (450px X 300px) in which our circles can move
    final Rectangle drawArea = RectangleBuilder.create()
            .width(DRAW_AREA_WIDTH).height(DRAW_AREA_HEIGHT)
            .fill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(1, Color.rgb(156, 216, 255)),
                    new Stop(0, Color.rgb(156, 216, 255, 0.5))))
            .stroke(Color.BLACK)
            .build();
    //variables for storing initial position before drag of circle
    private double initX;
    private double initY;
    private Point2D dragAnchor;

    public EditTaskGraphPage() {

        drawArea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (drawButton.isSelected() && xInBounds(me.getX(), DEFAULT_RADIUS) && yInBounds(me.getY(), DEFAULT_RADIUS)) {


                    final Node node = new Circle(30.0, Color.RED); //ProcessorGraphics.createNewProcessorGraphics();
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
                    getChildren().add(node);
                }

            }
        });

        drawButton = new ToggleButton("draw tool");

        // show all the circle , rectangle and console
        getChildren().addAll(drawArea, drawButton);
    }


    private static boolean xInBounds(double x, double circleRadius) {
        return (x >= 0) && (x <= 450 - circleRadius);
    }

    private static boolean yInBounds(double y, double circleRadius) {
        return (y >= 0) && (y <= 300 - circleRadius);
    }

}
