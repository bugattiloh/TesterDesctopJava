package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static launcher.Main.closeForm;

public class ResultOfParticipantScreenController {
    @FXML
    public Label BestResult;
    @FXML
    public Label nickNameOfParticipantTitle;
    @FXML
    public Button buttonBackToHelloScreen;

    private void openHelloScreen(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ui/HelloScreen.fxml"));
            Parent root = fxmlLoader.load();
            HelloScreenController controllerResult = fxmlLoader.getController();
            Stage s = new Stage();
            s.setScene(new Scene(root, 500, 500));
            s.show();
            closeForm(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void backToHelloScreenClick(ActionEvent back) {

        closeForm(back);
        openHelloScreen(back);

    }
}
