package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by Poghos Petrosyan on 06/10/2018. For AirportManager2
 */
public class SigninUI {
    @FXML
    javafx.scene.control.TextField TFullName;
    @FXML
    javafx.scene.control.TextField TBirthDate;
    @FXML
    javafx.scene.control.TextField TLogin;
    @FXML
    javafx.scene.control.TextField TEmail;
    @FXML
    javafx.scene.control.PasswordField PPasswd;
    @FXML
    javafx.scene.control.PasswordField PVPasswd;


    public SigninUI() {
    }

    public void cancel(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void signIn(ActionEvent actionEvent) {
    }
}
