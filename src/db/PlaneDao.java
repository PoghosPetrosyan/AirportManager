package db;

import entity.Plane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Poghos Petrosyan on 06/03/2018. For AirportManager2
 */
public class PlaneDao {
    public void addPlane(Plane plane){
        PreparedStatement stmt = null;
        Connection conn = DB_Connector.getConnection();
        try {
            String sql = "INSERT INTO airplanes(name,releaseDate,hoursInAir) " + "VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,plane.getName());
            stmt.setDate(2, (Date) plane.getReleaseDate());
            stmt.setInt(3,plane.getHoursInAir());
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
    public void editPlane(Plane plane){
        Connection conn = DB_Connector.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "update airplanes set name=?,releaseDate=?,hoursInAir=?,=?,status=? where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,plane.getName());
            stmt.setDate(2, (Date) plane.getReleaseDate());
            stmt.setInt(3, plane.getHoursInAir());
            stmt.setInt(5, plane.getId());

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
    public void deletePlane(int planeId) {
        Connection conn = DB_Connector.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "delete from airplanes where id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, planeId);
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
    public List<Plane> getAllPlanes(){
        List<Plane> planes = new ArrayList<>();
        Connection conn = DB_Connector.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = "select * from airplanes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Plane plane = new Plane();
                plane.setId(rs.getInt("id"));
                plane.setName(rs.getString("name"));
                plane.setReleaseDate(rs.getDate("releaseDate"));
                plane.setHoursInAir(rs.getInt("hoursInAir"));
                planes.add(plane);
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
        return planes;
    }
}
