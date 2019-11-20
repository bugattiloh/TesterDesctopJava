package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import staticContext.StaticHolder;
import tests.*;

public class TestScreenController {
    @FXML
    public Label labelQuestion;
    @FXML
    public TextArea textAreaAnswer;
    @FXML
    public Label labelTEST;
    @FXML
    public Button buttonNextQuestion;

    private TestParticipant participant;
    private Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @FXML
    public void nextQuestionClick(ActionEvent actionEvent) {

        test.nextQuestionIndex();
        Question question = new Question("hello");
        TrueAnswer trueAnswer = new TrueAnswer("bye");
        test.addTrueAnswers(trueAnswer);
        labelQuestion.setText(question.getQuestion());
        AnswerOfParticipant answerOfParticipant = new AnswerOfParticipant(textAreaAnswer.getText());
        test.addAnswerOfParticipant(answerOfParticipant);
        if (test.isThisTrueAnswer(test.getCurrentQuestionIndex())) {
            StaticHolder.participant.setResultOfTest();
        }
        textAreaAnswer.setText(null);
    }

    public TestParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(TestParticipant participant) {
        this.participant = participant;
    }

}
