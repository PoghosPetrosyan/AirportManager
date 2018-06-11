import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AirportManagaer extends Application{
    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./ui/LoginUI.fxml"));
        primaryStage.setTitle("Airport Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
