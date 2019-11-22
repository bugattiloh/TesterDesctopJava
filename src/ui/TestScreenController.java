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
import staticContext.StaticHolder;
import tests.Answers.AnswerOfParticipant;
import tests.Question;
import tests.Answers.TrueAnswer;

import java.io.IOException;

import static launcher.Main.infoBox;


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
        if (StaticHolder.test.getCurrentQuestionIndex() == 0) {
            AnswerOfParticipant answerOfParticipant = new AnswerOfParticipant(textAreaAnswer.getText());
            StaticHolder.test.addAnswerOfParticipant(answerOfParticipant);
            if (StaticHolder.test.isThisTrueAnswer(StaticHolder.test.getCurrentQuestionIndex())) {
                StaticHolder.participant.setResultOfTest();
            }
            StaticHolder.test.nextQuestionIndex();
        } else {
            Question question = new Question("hello");
            TrueAnswer trueAnswer = new TrueAnswer("bye");
            StaticHolder.test.addTrueAnswers(trueAnswer);
            labelQuestion.setText(question.getQuestion());
            AnswerOfParticipant answerOfParticipant = new AnswerOfParticipant(textAreaAnswer.getText());
            StaticHolder.test.addAnswerOfParticipant(answerOfParticipant);
            if (StaticHolder.test.isThisTrueAnswer(StaticHolder.test.getCurrentQuestionIndex())) {
                StaticHolder.participant.setResultOfTest();
            }
            StaticHolder.test.nextQuestionIndex();
        }
        if(StaticHolder.test.isThisTheEnd()){
            infoBox("Enter OK .", "The end of Test", "'Your result-"+StaticHolder.participant.getResultOfTest()+"/10");
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

        }
    }


}
