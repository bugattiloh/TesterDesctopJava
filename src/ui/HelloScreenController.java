package ui;

import javafx.event.ActionEvent;
import statics.FXMLHelper;

public class HelloScreenController {
    public void onButtonEnterClick(ActionEvent actionEvent) {
        FXMLHelper.loadScreen("EnterScreen");
    }

    public void onButtonRegisterClick(ActionEvent actionEvent) {
        FXMLHelper.loadScreen("RegisterScreen");
    }

    public void onButtonLeaderboardClick(ActionEvent actionEvent) {
        LeaderboardScreenController leaderboardScreen = FXMLHelper.loadScreenReturnController("LeaderboardScreen");
        leaderboardScreen.prerun();
    }
}
