package ui;

import db.EmployeeDao;
import entity.Employee;
import entity.MD5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
    @FXML
    javafx.scene.control.Label LFullName;
    @FXML
    javafx.scene.control.Label LBirthdate;
    @FXML
    javafx.scene.control.Label LLogin;
    @FXML
    javafx.scene.control.Label LEmail;
    @FXML
    javafx.scene.control.Label LPasswd;
    @FXML
    javafx.scene.control.Label LVPasswd;
    @FXML
    javafx.scene.control.Label Lmessage;
    @FXML
    javafx.scene.control.RadioButton RAdmin;
    @FXML
    javafx.scene.control.RadioButton RUser;

    private boolean flag;


    public SigninUI() {
    }

    public void cancel(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void signIn(ActionEvent actionEvent) {
        EmployeeDao ed = new EmployeeDao();
        Employee employee = new Employee();
        if (isFullNameValid(TFullName.getText())) {
            employee.setFullName(TFullName.getText());
            flag = true;
        } else {
            flag = false;
            LFullName.setTextFill(Color.RED);
            Lmessage.setVisible(true);
            Lmessage.setTextFill(Color.RED);
            Lmessage.setText("Full Name Not Valid");
        }
        if (isBirthDayValid(TBirthDate.getText())) {
            employee.setBirthday(TBirthDate.getText());
            flag = true;
        } else {
            LBirthdate.setTextFill(Color.RED);
            Lmessage.setVisible(true);
            Lmessage.setTextFill(Color.RED);
            Lmessage.setText("Birth date is not valid please use this format yyyy-mm-dd");
            flag = false;
        }
        if (isLoginValid(TLogin.getText())) {
            flag = true;
            employee.setLogin(TLogin.getText());
        } else {
            LLogin.setTextFill(Color.RED);
            Lmessage.setVisible(true);
            Lmessage.setTextFill(Color.RED);
            Lmessage.setText("Login is not valid! Length of login must be less than 10 chars.");
            flag = false;
        }
        if (isEmailValid(TEmail.getText())) {
            flag = true;
            employee.setEmail(TEmail.getText());
        } else {
            LEmail.setTextFill(Color.RED);
            Lmessage.setVisible(true);
            Lmessage.setTextFill(Color.RED);
            Lmessage.setText("Email is not valid! Ex. example@example.ex");
            flag = false;
        }
        if (PPasswd.getText().equals(PVPasswd.getText())) {
            if (isPasswordValid(PPasswd.getText())) {
                employee.setPassword(MD5.make(PPasswd.getText()));
                flag = true;
            } else {
                LPasswd.setTextFill(Color.RED);
                Lmessage.setVisible(true);
                Lmessage.setTextFill(Color.RED);
                Lmessage.setText("Password length must be 8 character and must contain 2 uppercase and 3 numbers");
                flag = false;
            }
        } else {
            LVPasswd.setTextFill(Color.RED);
            Lmessage.setVisible(true);
            Lmessage.setTextFill(Color.RED);
            Lmessage.setText("Passwords dose not much!");
            flag = false;
        }

        if (RAdmin.isSelected()) {
            employee.setStatus("A");
            RUser.setSelected(false);
        }

        if (RUser.isSelected()) {
            employee.setStatus("U");
            RAdmin.setSelected(false);
        }


        if (flag) {
            ed.addUser(employee);
            cancel(actionEvent);
        }
    }

    private boolean isFullNameValid(String name) {
        String[] fullNames = name.split(" ");
        for (String n : fullNames) {
            if (n.contains("-")) {
                String[] longNames = n.split("-");
                for (String n1 : longNames) {
                    int firstChar = n1.charAt(0);
                    if (firstChar < 65)
                        return false;
                    if (firstChar > 90)
                        return false;
                    for (int i = 1; i < n1.length(); i++) {
                        int nextChar = n1.charAt(i);
                        if (nextChar < 97)
                            return false;
                        if (nextChar > 122)
                            return false;
                    }
                }
            } else {
                int firstChar = n.charAt(0);
                if (firstChar < 65)
                    return false;
                if (firstChar > 90)
                    return false;
                for (int i = 1; i < n.length(); i++) {
                    int nextChar = n.charAt(i);
                    if (nextChar < 97)
                        return false;
                    if (nextChar > 122)
                        return false;

                }
            }

        }
        return true;
    }

    private boolean isBirthDayValid(String birthday) {
        String[] dates = birthday.split("-");
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int year = Integer.parseInt(dates[0]);
        int currentYear = LocalDate.now().getYear();

        if (month <= 0 || month > 13 || day <= 0 || day > 32 || (currentYear - year) < 18 || (currentYear - year) > 68)
            return false;
        return true;
    }

    public boolean isLoginValid(String name) {
        return name.length() < 11;
    }

    private boolean isPasswordValid(String p) {
        if (p.length() < 8)
            return false;
        int uCount = 0;
        int nCount = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) > 64 && p.charAt(i) < 91)
                uCount++;
            if (p.charAt(i) > 47 && p.charAt(i) < 58)
                nCount++;
        }
        if (uCount < 2)
            return false;
        if (nCount < 3)
            return false;
        return true;
    }

    private boolean isEmailValid(String address) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(address);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
