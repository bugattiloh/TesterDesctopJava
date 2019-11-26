package ui;

import DataBase.SqlToApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import staticContext.StaticHolder;
import tests.Question;

import java.io.IOException;

import static launcher.Main.closeForm;
import static launcher.Main.infoBox;

public class HelloScreenController {

    @FXML
    public Button buttonStartTest;
    @FXML
    public TextArea textAreaNickname;
    @FXML
    public Button buttonCheckResult;

    /*private void openTestScreen(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/TestScreen.fxml"));
            Parent root = fxmlLoader.load();
            TestScreenController controllerTest = fxmlLoader.getController();
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
            closeForm(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private void openResultOfParticipantScreen(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/ResultOfParticipantScreen.fxml"));
            Parent root = fxmlLoader.load();
            ResultOfParticipantScreenController controllerResult = fxmlLoader.getController();
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
            closeForm(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void startTestClick(ActionEvent startTest) {
        //проверка на наличие никнейма
        if (textAreaNickname.getText().equals("")) {

            infoBox("Enter yor nickname,please.", "Error", "'Nickname' field cannot be empty.");
        } else
            try {
                SqlToApplication sql=new SqlToApplication();
                //создаю статический объекты (Участник и сам тест) для данного теста
                StaticHolder staticHolder = new StaticHolder(textAreaNickname.getText());
                sql.addParticipantToDb(textAreaNickname.getText());
                //открываю TestScreen и закрываю HelloScreen
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/TestScreen.fxml"));
                Parent root = fxmlLoader.load();
                TestScreenController controllerTest = fxmlLoader.getController();
                Stage s = new Stage();
                s.setScene(new Scene(root, 500, 500));
                s.show();
                closeForm(startTest);
                //оформляю HelloScreen
                int indexNow=StaticHolder.test.getCurrentQuestionIndex();
                Question question = new Question(indexNow,sql.getQuestionFromDbById(indexNow),sql.getTrueAnswerFromDbById(indexNow));
                StaticHolder.test.addTrueAnswers(question.getTrue_answer());
                controllerTest.labelQuestion.setText(question.getQuestion());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void checkResultClick(ActionEvent checkResult) {
        if (textAreaNickname.getText().equals("")) {
            infoBox("Enter yor nickname,please.", "Error", "'Nickname' field cannot be empty.");
        } else {
            openResultOfParticipantScreen(checkResult);
            //ЗАНОС ДАННЫХ УЧАСТНИКА В НУЖНЫЕ ЛЕЙБЛЫ
            closeForm(checkResult);
        }
    }
}

