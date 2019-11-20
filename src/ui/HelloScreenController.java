package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import tests.TestParticipant;

import java.io.IOException;

public class HelloScreenController {
    @FXML
    public Button buttonStartTest;
    @FXML
    public TextArea textAreaNickname;
    @FXML
    public Button buttonCheckResult;

    private static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @FXML
    public void startTestClick(ActionEvent actionEvent) {
        if (textAreaNickname.getText().equals("")) {
            infoBox("Enter yor nickname,please.", "Error", "'Nickname' field cannot be empty.");
        } else
            try {
                TestParticipant tester = new TestParticipant(textAreaNickname.getText());

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/TestScreen.fxml"));
                Parent root = fxmlLoader.load();
                TestScreenController controller =  fxmlLoader.getController();
                controller.setParticipant(tester);

                //Parent root = FXMLLoader.load(getClass().getResource("../ui/TestScreen.fxml"));
                Stage s = new Stage();

                s.setScene(new Scene(root, 500, 500));
                s.show();
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}

