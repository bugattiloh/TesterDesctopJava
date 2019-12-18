package ui;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import statics.Database;
import statics.FXMLHelper;

public class RegisterScreenController {
    public TextField textFieldLogin;
    public PasswordField passwordFieldPassword;
    public TextField textFieldEmail;

    public void onButtonBackClick(ActionEvent actionEvent) {
        FXMLHelper.backScreen();
    }

    public void onButtonRegisterClick(ActionEvent actionEvent) {
        String login = textFieldLogin.getText();
        String password = passwordFieldPassword.getText();
        String email = textFieldEmail.getText();
        if (login.trim().length() == 0 || password.trim().length() == 0 || email.trim().length() == 0) {
            FXMLHelper.infoBox("ERROR", "CANT HANDLE IT", "LOGIN OR PASSWORD OR EMAIL WERE EMPTY");
            return;
        }

        User user = new User(0, login, password, email);
        Database.insertUser(user);
        FXMLHelper.backScreen();
    }
}
