package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class TestScreenController {

    @FXML
    public Label labelQuestion;
    @FXML
    public TextArea textAreaAnswer;
    @FXML
    public Label labelTEST;
    @FXML
    public Button buttonNextQuestion;

    @FXML
    public void nextQuestionClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../ui/TestScreen.fxml"));
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
