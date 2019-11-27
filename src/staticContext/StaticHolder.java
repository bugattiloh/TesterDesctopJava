package staticContext;


import tests.Test;
import tests.TestParticipant;



public class StaticHolder {
    public static Test test;
    public static TestParticipant participant;

    public StaticHolder(String nameOfParticipant,TestParticipant obj) {
        StaticHolder.test = new Test();
        StaticHolder.participant = obj;
    }
}
