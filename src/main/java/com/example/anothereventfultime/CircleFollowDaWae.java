package com.example.anothereventfultime;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleFollowDaWae extends Pane implements EventHandler<MouseEvent> {

    private Circle circ = new Circle();

    public CircleFollowDaWae() {
        this.setPrefSize(250, 250);

        circ.setCenterX(125);
        circ.setCenterY(125);
        circ.setRadius(50);
        circ.setFill(Color.GREEN);
        circ.setStroke(Color.BLACK);

        /* Anything could be listening to our event in our program, from some other
        class, to even "this"
         */
        this.setOnMouseMoved(this);
        this.setOnMouseClicked(this);

        this.getChildren().add(circ);

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        System.out.println(mouseEvent.getSource());
        System.out.println(mouseEvent.getEventType());

        if(mouseEvent.getEventType() == MouseEvent.MOUSE_MOVED){
            //here we move our circle with our mouse cursor...
            circ.setCenterX(mouseEvent.getX());
            circ.setCenterY(mouseEvent.getY());
        }

        //here is the event where the color of the circle changes
        if(mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
            circ.setFill(Color.BLUE);
        }
    }
}
