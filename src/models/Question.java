package models;

public class Question {
    private int id;
    private String question;
    private String correct;

    public Question(int id, String question, String correct) {
        this.id = id;
        this.question = question;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
