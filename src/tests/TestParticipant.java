package tests;

public class TestParticipant {
    int id;
    private String name;
    private String password;
    private String phoneNumber;
    private int resultOfTest;


    public TestParticipant(int id,String name,String password,String phoneNumber,int resultOfTest) {
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
