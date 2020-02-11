package ui;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;
import statics.Database;
import statics.FXMLHelper;

public class EnterScreenController {
    public TextField textFieldLogin;
    public PasswordField passwordFieldPassword;

    public void onButtonBackClick(ActionEvent actionEvent) {
        FXMLHelper.backScreen();
    }

    public void onButtonEnterClick(ActionEvent actionEvent) {
        String login = textFieldLogin.getText();
        String password = passwordFieldPassword.getText();
        if (login.trim().length() == 0 || password.trim().length() == 0) {
            FXMLHelper.infoBox("ERROR", "CANT HANDLE IT", "LOGIN OR PASSWORD WERE EMPTY");
            return;
        }

        User user = Database.getUserByLoginAndPassword(login, password);
        if (user == null) {
            FXMLHelper.infoBox("ERROR", "CANT HANDLE IT", "USER NOT FOUND");
            return;
        }

        User.activeUser = user;
        TestScreenController testScreen = FXMLHelper.loadScreenReturnController("TestScreen");
        testScreen.prerun();
    }
}
