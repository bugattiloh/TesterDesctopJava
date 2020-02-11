package statics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Stack;

public class FXMLHelper {
    private static final String pathToScreens = "../ui/";
    private static Stage primaryStage;
    private static Stack<Scene> chronologicalScenes = new Stack<>();

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    private static void createScreen(Parent root) {
        chronologicalScenes.push(primaryStage.getScene());
        Scene scene = new Scene(root);
        setScene(scene);
    }
    public static void backToStartScreen() {
        while (chronologicalScenes.size() > 1) {
            backScreen();
        }
    }
    public static void loadScreen(String screen) {
        try {
            Parent root = FXMLLoader.load(FXMLHelper.class.getResource(pathToScreens + screen + ".fxml"));
            createScreen(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> T loadScreenReturnController(String screen) {
        T controller = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXMLHelper.class.getResource(pathToScreens + screen + ".fxml"));
            loader.load();
            Parent root = loader.getRoot();
            controller = loader.getController();
            createScreen(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return controller;
    }
    public static void backScreen() {
        if (chronologicalScenes.size() > 1) {
            Scene pop = chronologicalScenes.pop();
            setScene(pop);
        }
    }
    private static void setScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setHeight(primaryStage.getHeight() + 20);
        primaryStage.setWidth(primaryStage.getWidth() + 20);
    }
    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
        alert.close();
    }
}