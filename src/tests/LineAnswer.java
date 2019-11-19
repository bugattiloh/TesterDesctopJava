package tests;


class LineAnswer extends Answer {
    private String lineAnswer;

    public LineAnswer(String content) {
        super("string");
        this.lineAnswer = content;
    }

    @Override
    public String getData() {
        return lineAnswer;
    }

}
