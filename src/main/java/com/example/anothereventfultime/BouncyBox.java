package com.example.anothereventfultime;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
//Make sure its javafx.util.Duration, and nothing else... like time.Duration
import javafx.util.Duration;

import java.util.EventListener;

public class BouncyBox extends Pane implements EventHandler<ActionEvent> {

    private Rectangle r;
    private PathTransition p;

    public BouncyBox(){
        //Setup pane
        this.setWidth(200);
        this.setHeight(200);
        this.setPrefWidth(200);
        this.setPrefHeight(200);

        //Setup box
        r = new Rectangle();
        r.setLayoutX(20);
        r.setLayoutY(20);
        r.setWidth(10);
        r.setHeight(10);

        Button play = new Button();
        play.setText("Play");
        play.setLayoutX(150);
        play.setOnAction(this);

        Button stop = new Button();
        stop.setText("Stop");
        stop.setLayoutX(150);
        stop.setLayoutY(40);
        stop.setOnAction(this);

        Button pause = new Button();
        pause.setText("Pause");
        pause.setLayoutX(150);
        pause.setLayoutY(80);
        pause.setOnAction(this);

        this.getChildren().add(r);
        this.getChildren().add(play);
        this.getChildren().add(stop);
        this.getChildren().add(pause);

        /* Now how do we animate?
         *  - We first need a duration to determine how quickly our animation will go
         *  */


        /* This is to say we have a transition with a duration of 20000 milliseconds, the line it will follow, and what
        object will move across said line. It's a diagonal line!
         */
        p = new PathTransition(Duration.millis(20000), new Line(20, 20, 170, 170), r);
        //Now auto reverse the animation
        p.setAutoReverse(true);
        //The above does not get the jobs done entirely though, but it will allow for the next to be done
        p.setCycleCount(4);
        //Now it will take on another cycle and go back to upper left!

        //Now make it faster
        p.setRate(10);

        //Now play it!
        //p.play();

        //Now we may jump to any point along our animation cycle
        p.jumpTo(Duration.seconds(10));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource().toString().contains("Play")){
            p.play();
        }

    }
}
