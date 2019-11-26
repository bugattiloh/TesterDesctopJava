package tests;

public class Question {

    private int id;
    private String question;
    private String true_answer;

    public Question(int id, String question, String true_answer) {
        this.id = id;
        this.question = question;
        this.true_answer = true_answer;
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

    public String getTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(String true_answer) {
        this.true_answer = true_answer;
    }
}
