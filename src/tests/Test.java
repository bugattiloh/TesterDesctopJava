package tests;

import tests.Answers.AnswerOfParticipant;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<String> trueAnswers;
    private List<AnswerOfParticipant> answersOfParticipant;
    private int currentQuestionIndex;

    public Test() {
        currentQuestionIndex = 1;
        trueAnswers = new ArrayList<>();
        answersOfParticipant = new ArrayList<>();
        trueAnswers.add(0, "");
        answersOfParticipant.add(0, null);
    }

    public void addTrueAnswers(String trueAnswer) {
        trueAnswers.add(currentQuestionIndex, trueAnswer);
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
        return trueAnswers.get(currentQuestionIndex).equals(answersOfParticipant.get(currentQuestionIndex).getAnswer());
    }

    public boolean isThisTheEnd() {
        return (currentQuestionIndex == 11);
    }


}



