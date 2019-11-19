package tests;

import java.util.List;

public class Question {

    private List<Answer> answers;
    private String content;


    public Question(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
