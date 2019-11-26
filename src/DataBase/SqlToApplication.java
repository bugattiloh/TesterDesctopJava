package DataBase;

import tests.Question;

import java.sql.*;

public class SqlToApplication {
    private static final String url = "jdbc:mysql://localhost:3306/testingdb";
    private static final String user = "root";
    private static final String password = "root";


    public Question getQuestionById(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM questions WHERE id='%d'", id));
            Question q = null;
            if (rs.next()) {
                int db_id = rs.getInt("id");
                String db_question = rs.getString("question");
                String db_true_answer = rs.getString("true_answer");
                q = new Question(db_id, db_question, db_true_answer);
            }
            rs.close();
            connection.close();
            return q;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getTrueAnswerFromDbById(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM questions WHERE id='%d'", id));
            String db_true_answer = "";
            if (rs.next()) {
                db_true_answer = rs.getString("true_answer");
            }
            rs.close();
            connection.close();
            return db_true_answer;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getQuestionFromDbById(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement preparedStatement = connection.prepareStatement(String.format("SELECT * FROM questions WHERE id='%d'", id));

            ResultSet rs = preparedStatement.executeQuery(String.format("SELECT * FROM questions WHERE id='%d'", id));
            String db_question = "";
            if (rs.next()) {
                db_question = rs.getString("question");
            }
            rs.close();
            connection.close();

            return db_question;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addParticipantToDb(String name) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            String insertParticipant = "INSERT INTO test_participant"
                    + "(nickname) " + "VALUES"
                    + "("+name+")";
            ResultSet rs = statement.executeQuery(insertParticipant);
            rs.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


