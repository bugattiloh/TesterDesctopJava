package tests;

import java.util.List;

public class Test {

    private List<TrueAnswer> trueAnswers;
    private List<AnswerOfParticipant> answersOfParticipant;
    private int currentQuestionIndex;

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public void start() {
        currentQuestionIndex = 0;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public boolean isThisTrueAnswer(int currentQuestionIndex) {
        return trueAnswers.get(currentQuestionIndex).getAnswer().equals(answersOfParticipant.get(currentQuestionIndex).getAnswer());
    }

}



