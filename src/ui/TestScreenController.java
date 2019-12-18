package ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.LeaderBoard;
import models.Question;
import models.User;
import statics.Database;
import statics.FXMLHelper;

import java.util.List;

public class TestScreenController {
    public Label labelQuestion;
    public TextField textFieldUserAnswer;
    private int questionIndex = -1;
    private int score = 0;
    private List<Question> questions;

    public void prerun() {
        questions = Database.selectQuestions();
        nextQuestion();
    }

    public void nextQuestion() {
        questionIndex++;
        if (questionIndex == questions.size()) {
            FXMLHelper.infoBox("END TEST", "END", "You've scored " + score);

            LeaderBoard leaderBoard = new LeaderBoard(0, User.activeUser.getId(), score);
            Database.insertLeaderBoard(leaderBoard);

            FXMLHelper.backToStartScreen();
        } else {
            labelQuestion.setText(questions.get(questionIndex).getQuestion());
        }
    }

    private void submitQuestion() {
        String userAnswer = textFieldUserAnswer.getText();
        if (questions.get(questionIndex).getCorrect().equals(userAnswer)) {
            score++;
        }
        textFieldUserAnswer.clear();
    }

    public void onButtonSubmitClick(ActionEvent actionEvent) {
        submitQuestion();
        nextQuestion();
    }
}
