package entity;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Poghos Petrosyan on 06/02/2018. For AirportManager2
 */

public class Employee {
    private String fullName;
    private Date birthday;
    private int id;
    private String login;
    private String password;
    private String email;
    private String status;

    public Employee() {}

    public Employee(String fullName,  Date birthday, String login, String password, String email, String status) {
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
        if(isFullNameValid(fullName))
            this.fullName = fullName;
        this.fullName = "Null Null";
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
        if (isBirthDayValid(birthday))
            this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        else
            this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse("9999-99-99");
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        if (isLoginValid(login))
            this.login = login;
        this.login = "incorrectLogin";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(isPasswordValid(password))
            this.password = password;
        this.password = "incorrectPassword";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
        this.email = "invalid@email.com";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    private boolean isBirthDayValid(String birthday)
    {
        String[] dates = birthday.split("-");
        int month = Integer.parseInt(dates[2]);
        int day = Integer.parseInt(dates[3]);
        int year = Integer.parseInt(dates[0]);
        int currentYear = LocalDate.now().getYear();

        if (month <= 0 || month > 13 || day <= 0 || day > 32 || (currentYear - year) < 18 || (currentYear - year) > 68 )
            return false;
        return true;
    }

    public boolean isLoginValid(String name) {
        return name.length() > 11;
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
