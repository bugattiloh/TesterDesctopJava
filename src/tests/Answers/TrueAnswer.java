package tests.Answers;

import tests.Answers.Answer;

public class TrueAnswer extends Answer {
    private String trueAnswer;

    public TrueAnswer(String content) {
        super();
        trueAnswer = content;
    }

    @Override
    public String getAnswer() {
        return trueAnswer;
    }

}
