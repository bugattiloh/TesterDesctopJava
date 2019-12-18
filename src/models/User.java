package models;

public class User {
    private int id;
    private String nickname;
    private String password;
    private String email;

    public static User activeUser;

    public User(int id, String nickname, String password, String email) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
