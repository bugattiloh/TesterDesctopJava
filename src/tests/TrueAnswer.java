package tests;

public class TrueAnswer extends Answer {
    private String trueAnswer;

    public TrueAnswer(String content) {
        super();
    }

    @Override
    public String getAnswer() {
        return trueAnswer;
    }

}
