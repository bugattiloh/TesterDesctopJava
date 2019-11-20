package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import tests.AnswerOfParticipant;
import tests.Question;
import tests.Test;
import tests.TestParticipant;

public class TestScreenController {
    Test test=new Test();

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
        test.start();
        Question question =new Question("hello");
        labelQuestion.setText(question.getQuestion());
        AnswerOfParticipant answerOfParticipant=new AnswerOfParticipant(textAreaAnswer.getText());
        if (test.isThisTrueAnswer(test.getCurrentQuestionIndex())){
            tester.
        }
        textAreaAnswer.setText(null);
    }
}
