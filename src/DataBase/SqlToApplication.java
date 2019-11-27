package DataBase;

import tests.Question;
import tests.TestParticipant;

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


    public TestParticipant getParticipantbyNickname(String name) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM test_participant WHERE nickname='%s'", name));
            TestParticipant db_participant = null;
            if (rs.next()) {
                int db_id = rs.getInt("id");
                String db_name = rs.getString("nickname");
                String db_password = rs.getString("password");
                String db_phoneNumber = rs.getString("phone_number");
                int db_resultOfaTest = rs.getInt("result_of_test");
                db_participant = new TestParticipant(db_id, db_name, db_password, db_phoneNumber, db_resultOfaTest);
            }
            statement.close();
            rs.close();
            connection.close();
            return db_participant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}



