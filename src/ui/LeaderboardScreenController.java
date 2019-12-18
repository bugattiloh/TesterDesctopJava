package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.LeaderBoard;
import models.LeaderBoardJoined;
import statics.Database;
import statics.FXMLHelper;

import java.util.List;

public class LeaderboardScreenController {
    public TableView<LeaderBoard> tableViewLeaderboard;
    @FXML
    private TableColumn<LeaderBoard, Integer> idColumn;

    @FXML
    private TableColumn<LeaderBoardJoined, String> nicknameColumn;

    @FXML
    private TableColumn<LeaderBoard, String> scoreColumn;

    public void prerun() {

        // устанавливаем тип и значение которое должно хранится в колонке
        idColumn.setCellValueFactory(new PropertyValueFactory<LeaderBoard, Integer>("id"));
        nicknameColumn.setCellValueFactory(new PropertyValueFactory<LeaderBoardJoined, String>("userNickname"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<LeaderBoard, String>("score"));

        List<LeaderBoardJoined> leaderBoardJoineds = Database.selectLeaderBoard();

        // заполняем таблицу данными
        tableViewLeaderboard.getItems().addAll(leaderBoardJoineds);
    }

    public void onButtonBackClick(ActionEvent actionEvent) {
        FXMLHelper.backScreen();
    }
}
