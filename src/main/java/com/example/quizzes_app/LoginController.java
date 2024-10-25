package com.example.quizzes_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessage;

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            loginMessage.setText("Please enter both username and password.");
        } else {
            // هنا يمكنك استبدال هذا المنطق بمسار التحقق من البيانات من قاعدة البيانات
            if (isStudent(username, password)) {
                loginMessage.setText("Login successful!");
                loadAvailableQuizzes();
            } else if (isTeacher(username, password)) {
                loginMessage.setText("Login successful!");
                loadTeacherDashboard();
            } else {
                loginMessage.setText("Invalid username or password.");
            }
        }
    }

    // دالة للتحقق مما إذا كان المستخدم طالبًا
    private boolean isStudent(String username, String password) {
        // منطق تحقق تسجيل دخول الطالب هنا (تستطيع تعديل هذا حسب بياناتك)
        return "student".equals(username) && "studentpass".equals(password);
    }

    // دالة للتحقق مما إذا كان المستخدم معلمًا
    private boolean isTeacher(String username, String password) {
        // منطق تحقق تسجيل دخول المعلم هنا (تستطيع تعديل هذا حسب بياناتك)
        return "teacher".equals(username) && "teacherpass".equals(password);
    }

    // دالة لتحميل صفحة الكويزات المتاحة
    private void loadAvailableQuizzes() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("available-quizzes-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 550);

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Available Quizzes - Quizzes App");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // دالة لتحميل واجهة المعلم
    private void loadTeacherDashboard() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("teacher-dashboard-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 550);

            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Teacher Dashboard - Quizzes App");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRegisterButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 550);

        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Register - Quizzes App");
        stage.show();
    }
}
