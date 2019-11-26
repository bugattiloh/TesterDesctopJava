package tests;

public class TestParticipant {
    int id;
    private String name;
    private String password;
    private int resultOfTest;


    public TestParticipant(String name) {
        this.name = name;
        this.resultOfTest = 0;
    }

    public String getName() {
        return name;
    }

    public int getResultOfTest() {
        return resultOfTest;
    }

    public void setResultOfTest() {
        this.resultOfTest++;
    }
}
