package statics;

import models.LeaderBoard;
import models.LeaderBoardJoined;
import models.Question;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String connectionString = "jdbc:mysql://localhost:3306/testingdb?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String login = "root";
    private static final String password = "root";
    private static Connection connection;
    private static boolean initiated = false;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
            initiated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close() {
        if (initiated) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE nickname='%s' AND password='%s' LIMIT 1", login, password));
            User user = null;
            if (resultSet.next()) {
                int db_id = resultSet.getInt("id");
                String db_nickname = resultSet.getString("nickname");
                String db_password = resultSet.getString("password");
                String db_email = resultSet.getString("email");
                user = new User(db_id, db_nickname, db_password, db_email);
            }
            resultSet.close();
            statement.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertUser(User u) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(
                    "INSERT INTO users (`nickname`, `password`, `email`) VALUES ('%s', '%s', '%s')", u.getNickname(), u.getPassword(), u.getEmail()));

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<LeaderBoardJoined> selectLeaderBoard() {
        List<LeaderBoardJoined> leaderboards = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT leaderboards.id, user_id, score, nickname FROM testingdb.leaderboards LEFT JOIN testingdb.users ON leaderboards.user_id=users.id ORDER BY leaderboards.id");
            LeaderBoardJoined leaderboard = null;
            while (resultSet.next()) {
                int db_id = resultSet.getInt("id");
                int db_user_id = resultSet.getInt("user_id");
                int db_score = resultSet.getInt("score");
                String db_nickname = resultSet.getString("nickname");
                leaderboard = new LeaderBoardJoined(db_id, db_user_id, db_score, db_nickname);
                leaderboards.add(leaderboard);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaderboards;
    }

    public static List<Question> selectQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM questions");
            Question question = null;
            while (resultSet.next()) {
                int db_id = resultSet.getInt("id");
                String db_question = resultSet.getString("question");
                String db_correct = resultSet.getString("correct");
                question = new Question(db_id, db_question, db_correct);
                questions.add(question);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static boolean isInitiated() {
        return initiated;
    }

    public static void insertLeaderBoard(LeaderBoard leaderBoard) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(
                    "INSERT INTO leaderboards (`user_id`, `score`) VALUES ('%d', '%d')", leaderBoard.getUser_id(), leaderBoard.getScore()));

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



