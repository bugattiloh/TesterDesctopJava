package staticContext;

import tests.Test;
import tests.TestParticipant;

public class StaticHolder {
    public static Test test;
    public static TestParticipant participant;

    public StaticHolder(String nameOfParticipant) {
        StaticHolder.test = new Test();
        StaticHolder.participant = new TestParticipant(nameOfParticipant);
    }
}
