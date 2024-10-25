package com.example.quizzes_app;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.List;

public class AvailableQuizzesController {

    @FXML
    private ListView<String> quizzesListView;

    // Simulate fetching quizzes from a database
    private List<String> fetchAvailableQuizzes() {
        return List.of(
                "Math Quiz 1",
                "Science Quiz 2",
                "History Quiz 3"
        ); // Replace with actual data fetching logic
    }

    @FXML
    public void initialize() {
        List<String> quizzes = fetchAvailableQuizzes();
        quizzesListView.getItems().addAll(quizzes);
    }

    @FXML
    private void onLogoutButtonClick() {
        // Handle logout logic here
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have logged out.", ButtonType.OK);
        alert.showAndWait();
        // Redirect to the login screen
        // For example: switchToLoginScene();
    }
}
