package tests;

import java.util.List;

public class Test {

    private List<Question> questions;
    private List<Answer> answers;
    private int currentQuestionIndex;

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void start() {
        currentQuestionIndex = 0;
    }

    public boolean CheckAnswer(int currentQuestionIndex) {
        return questions.get(currentQuestionIndex).getContent().equals(answers.get(currentQuestionIndex).getData());
    }
}



