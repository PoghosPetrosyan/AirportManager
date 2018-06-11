package db;

import entity.Employee;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public void addUser(Employee employee) {
        PreparedStatement stmt = null;
        Connection conn = DB_Connector.getConnection();
        try {
            String sql = "INSERT INTO employees(fullName,birthday,login,password,email,status) " + "VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFullName());
            stmt.setDate(2, (Date) employee.getBirthday());
            stmt.setString(3, employee.getLogin());
            stmt.setString(4, employee.getPassword());
            stmt.setString(5, employee.getEmail());
            stmt.setString(6, employee.getStatus());

            stmt.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void editUser(Employee employee) {
        Connection conn = DB_Connector.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "update employees set fullName=?,birthday=?,login=?,password=?,email=?,status=? where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,employee.getFullName());
            stmt.setDate(2, (Date) employee.getBirthday());
            stmt.setString(3, employee.getLogin());
            stmt.setString(4, employee.getPassword());
            stmt.setString(5, employee.getEmail());
            stmt.setString(6,employee.getStatus());
            stmt.setInt(5, employee.getId());

            stmt.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteUser(int employeeId) {
        Connection conn = DB_Connector.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "delete from employees where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> users = new ArrayList<>();
        Connection conn = DB_Connector.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "select * from employees";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setLogin(rs.getString("login"));
                employee.setPassword(rs.getString("password"));
                employee.setEmail(rs.getString("email"));
                employee.setBirthday(rs.getDate("birthday"));
                users.add(employee);
            }
            rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return users;
    }

}
