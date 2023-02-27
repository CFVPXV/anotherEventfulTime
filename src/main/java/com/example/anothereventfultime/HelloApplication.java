package com.example.anothereventfultime;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        CircleFollowDaWae circScene = new CircleFollowDaWae();
        Scene scene = new Scene(circScene);
        stage.setTitle("KircleWeg");
        stage.setScene(scene);
        stage.show();
    }

    /* Note that the essence of our events and listeners can be boiled down to the simple
    publish-subscribe model discussed in the SSE course. That is, multiple
     */
    public static void main(String[] args) {
        launch();
    }
}