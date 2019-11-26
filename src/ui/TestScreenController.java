package ui;

import DataBase.SqlToApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import staticContext.StaticHolder;
import tests.Answers.AnswerOfParticipant;
import tests.Question;

import java.io.IOException;

import static launcher.Main.*;


public class TestScreenController {
    @FXML
    public Label labelQuestion;
    @FXML
    public TextArea textAreaAnswer;
    @FXML
    public Label labelTEST;
    @FXML
    public Button buttonNextQuestion;

    private void openHelloScreenForm() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/HelloScreen.fxml"));
            Parent root = fxmlLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void nextQuestionClick(ActionEvent nextQuestion) {
        if (textAreaAnswer.getText().equals("")) {
            infoBox("Enter OK to continue.", "Your answer is empty", "Answer field cannot be empty.");
        } else {
            //ПРОВРЕКА НА ПЕРВЫЙ ВОПРОС
            if (StaticHolder.test.getCurrentQuestionIndex() == 0) {
                AnswerOfParticipant answerOfParticipant = new AnswerOfParticipant(textAreaAnswer.getText());
                StaticHolder.test.addAnswerOfParticipant(answerOfParticipant);
                if (StaticHolder.test.isThisTrueAnswer(StaticHolder.test.getCurrentQuestionIndex())) {
                    StaticHolder.participant.setResultOfTest();
                }
                StaticHolder.test.nextQuestionIndex();
                textAreaAnswer.setText(null);
            } else {
                SqlToApplication sql=new SqlToApplication();
                int indexNow=StaticHolder.test.getCurrentQuestionIndex();
                Question question = new Question(indexNow,sql.getQuestionFromDbById(indexNow),sql.getTrueAnswerFromDbById(indexNow));
                StaticHolder.test.addTrueAnswers(question.getTrue_answer());
                labelQuestion.setText(question.getQuestion());
                AnswerOfParticipant answerOfParticipant = new AnswerOfParticipant(textAreaAnswer.getText());
                StaticHolder.test.addAnswerOfParticipant(answerOfParticipant);
                if (StaticHolder.test.isThisTrueAnswer(StaticHolder.test.getCurrentQuestionIndex())) {
                    StaticHolder.participant.setResultOfTest();
                }
                textAreaAnswer.setText(null);
                StaticHolder.test.nextQuestionIndex();
            }
        }
        if (StaticHolder.test.isThisTheEnd()) {
            infoBox("Enter OK .", "The end of Test", "'Your result-" + StaticHolder.participant.getResultOfTest() + "/10");
            //ЗАНЕСТИ ДАННЫЕ В БАЗУ ДАННЫХ
            deleteTestAndParticipant();
            closeForm(nextQuestion);
            openHelloScreenForm();
        }
    }


}
