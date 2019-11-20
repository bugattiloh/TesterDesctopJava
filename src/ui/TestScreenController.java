package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import tests.AnswerOfParticipant;
import tests.Question;
import tests.Test;
import tests.TrueAnswer;

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
        test.nextQuestionIndex();
        Question question =new Question("hello");
        TrueAnswer trueAnswer=new TrueAnswer("bye");
        test.addTrueAnswers(trueAnswer);
        labelQuestion.setText(question.getQuestion());
        AnswerOfParticipant answerOfParticipant=new AnswerOfParticipant(textAreaAnswer.getText());
        test.addAnswerOfParticipant(answerOfParticipant);
        if (test.isThisTrueAnswer(test.getCurrentQuestionIndex())){
        //TODO
        }
        textAreaAnswer.setText(null);
    }

}
