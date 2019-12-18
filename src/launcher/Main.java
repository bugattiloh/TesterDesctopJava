package launcher;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import statics.Database;
import statics.FXMLHelper;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        Database.close();
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) {
        Database.connect();

        FXMLHelper.setPrimaryStage(primaryStage);
        FXMLHelper.loadScreen("HelloScreen");
        primaryStage.show();
    }

}
