module com.example.anothereventfultime {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.anothereventfultime to javafx.fxml;
    exports com.example.anothereventfultime;
}