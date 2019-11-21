package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import staticContext.StaticHolder;
import tests.AnswerOfParticipant;
import tests.Question;
import tests.TrueAnswer;


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
            textAreaAnswer.setText(null);
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
            textAreaAnswer.setText(null);
            StaticHolder.test.nextQuestionIndex();
        }
    }


}
