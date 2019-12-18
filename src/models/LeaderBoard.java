package models;

public class LeaderBoard {
    private int id;
    private int user_id;
    private int score;

    public LeaderBoard(int id, int user_id, int score) {
        this.id = id;
        this.user_id = user_id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
