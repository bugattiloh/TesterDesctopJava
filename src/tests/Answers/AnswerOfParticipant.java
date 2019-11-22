package tests.Answers;


import tests.Answers.Answer;

public class AnswerOfParticipant extends Answer {
    private String answerOfParticipant;

    public AnswerOfParticipant(String content) {
        super();
        this.answerOfParticipant = content;
    }

    @Override
    public String getAnswer() {
        return answerOfParticipant;
    }


}
