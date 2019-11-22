package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        createApplicationForTestingFuckingPeople();
        launch(args);
    }

    private static void createApplicationForTestingFuckingPeople() {

    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
        alert.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ui/HelloScreen.fxml"));
        primaryStage.setTitle("Тест на знание математики.");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

}
