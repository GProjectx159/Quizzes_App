package com.example.quizzes_app;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField sectionField;

    @FXML
    private TextField codeField;

    @FXML
    private ComboBox<String> teacherComboBox;

    @FXML
    private ComboBox<String> subjectComboBox;

    @FXML
    private Label registrationMessage;

    @FXML
    public void initialize() {
        // إضافة أسماء المعيدين والمقررات بشكل افتراضي - يمكن استبدالها ببيانات من قاعدة البيانات لاحقًا
        teacherComboBox.getItems().addAll("Dr. Ahmed", "Dr. Sarah", "Dr. Mahmoud");
        subjectComboBox.getItems().addAll("Mathematics", "Physics", "Chemistry", "Computer Science");
    }

    @FXML
    protected void onRegisterButtonClick() {
        String name = nameField.getText();
        String section = sectionField.getText();
        String code = codeField.getText();
        String selectedTeacher = teacherComboBox.getValue();
        String selectedSubject = subjectComboBox.getValue();

        // التحقق من صحة البيانات المدخلة
        if (name.isEmpty() || section.isEmpty() || code.isEmpty() || selectedTeacher == null || selectedSubject == null) {
            registrationMessage.setText("Please fill all fields.");
        } else {
            // هنا يمكن تخزين البيانات في قاعدة البيانات أو التعامل معها كما تحتاج
            registrationMessage.setText("Registration successful!");
            registrationMessage.setStyle("-fx-text-fill: green;");
        }
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 450);

        Stage stage = (Stage) registrationMessage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login - Quizzes App");
        stage.show();
    }
}
