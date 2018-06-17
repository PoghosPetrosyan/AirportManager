package ui;

import db.DB_Connector;
import db.EmployeeDao;
import entity.Employee;
import entity.MD5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logIn(ActionEvent actionEvent) {
        EmployeeDao ed = new EmployeeDao();
        List<Employee> employees = ed.getAllEmployees();
        for (Employee e : employees) {
            if (e.getLogin().equals(TLogin.getText()) && e.getPassword().equals(MD5.make(TPasswd.getText())) && e.getStatus().equals("A"))
                System.out.println("Admin");

            if (e.getLogin().equals(TLogin.getText()) && e.getPassword().equals(MD5.make(TPasswd.getText())) && e.getStatus().equals("U"))
                System.out.println("User");
        }
    }
}
