package tests;

public class IntAnswer extends Answer {
    private int number;

    public IntAnswer(String content) {
        super("int");
        this.number = Integer.parseInt(content);
    }

    @Override
    public String getData() {
        return Integer.toString(this.number);
    }

}
