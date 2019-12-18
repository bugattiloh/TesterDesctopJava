package models;

public class LeaderBoardJoined extends LeaderBoard {
    private String userNickname;

    public LeaderBoardJoined(int id, int user_id, int score, String userNickname) {
        super(id, user_id, score);
        this.userNickname = userNickname;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
