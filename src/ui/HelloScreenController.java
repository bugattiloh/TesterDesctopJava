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
import staticContext.StaticHolder;
import tests.Answers.TrueAnswer;
import tests.Question;
import tests.Test;
import tests.TestParticipant;

import java.io.IOException;

import static launcher.Main.infoBox;

public class HelloScreenController {

    @FXML
    public Button buttonStartTest;
    @FXML
    public TextArea textAreaNickname;
    @FXML
    public Button buttonCheckResult;
    private  void openHelloScreenForm(){
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/TestScreen.fxml"));
            Parent root = fxmlLoader.load();
            TestScreenController controller = fxmlLoader.getController();
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void startTestClick(ActionEvent actionEvent) {
        //проверка на наличие никнейма
        if (textAreaNickname.getText().equals("")) {
            infoBox("Enter yor nickname,please.", "Error", "'Nickname' field cannot be empty.");
        } else
            try {
                //создаю статический классы для данного теста
                StaticHolder.test = new Test();
                StaticHolder.participant = new TestParticipant(textAreaNickname.getText());
                //открываю TestScreen и закрываю HelloScreen
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/TestScreen.fxml"));
                Parent root = fxmlLoader.load();
                TestScreenController controllerTest = fxmlLoader.getController();
                Stage s = new Stage();
                s.setScene(new Scene(root, 500, 500));
                s.show();
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
                //оформляю HelloScreen
                Question question = new Question("hello");
                TrueAnswer trueAnswer = new TrueAnswer("bye");
                StaticHolder.test.addTrueAnswers(trueAnswer);
                controllerTest.labelQuestion.setText(question.getQuestion());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

