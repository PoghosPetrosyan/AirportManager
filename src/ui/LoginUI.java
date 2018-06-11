package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Poghos Petrosyan on 06/10/2018. For AirportManager2
 */
public class LoginUI {
    @FXML
    javafx.scene.control.TextField TLogin;
    @FXML
    javafx.scene.control.PasswordField TPasswd;

    public void signIn(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./SigninUI.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void logIn(ActionEvent actionEvent) {
    }
}
