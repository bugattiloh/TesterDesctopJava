package tests;


public class Answer {

    private String typeOfAnswer;

    protected Answer(String type) {
        this.typeOfAnswer = type;
    }

    public String getData() {
        return typeOfAnswer;
    }

    public boolean CheckTypeOfAnswer() {
        return this.typeOfAnswer.equals("string");
    }

}






