module com.example.quizzes_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.quizzes_app to javafx.fxml;
    exports com.example.quizzes_app;
}