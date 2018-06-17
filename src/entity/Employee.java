package entity;

import java.util.Date;

/**
 * Created by Poghos Petrosyan on 06/02/2018. For AirportManager2
 */

public class Employee {
    private String fullName;
    private String birthday;
    private int id;
    private String login;
    private String password;
    private String email;
    private String status;

    public Employee() {}

    public Employee(String fullName,  String birthday, String login, String password, String email, String status) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
