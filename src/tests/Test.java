package tests;

import java.util.List;

public  class Test {

    private List<TrueAnswer> trueAnswers;
    private List<AnswerOfParticipant> answersOfParticipant;
    private int currentQuestionIndex;

    public Test() {
        currentQuestionIndex = 0;
    }

    public void addTrueAnswers(TrueAnswer obj) {
        trueAnswers.add(currentQuestionIndex, obj);
    }

    public void addAnswerOfParticipant(AnswerOfParticipant obj) {
        answersOfParticipant.add(currentQuestionIndex, obj);
    }

    public void nextQuestionIndex() {
        currentQuestionIndex++;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public boolean isThisTrueAnswer(int currentQuestionIndex) {
        return trueAnswers.get(currentQuestionIndex).getAnswer().equals(answersOfParticipant.get(currentQuestionIndex).getAnswer());
    }
}



