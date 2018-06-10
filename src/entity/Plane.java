package entity;

import java.util.Date;

/**
 * Created by Poghos Petrosyan on 02/28/2018. For Exam
 */
public class Plane {
    private String name;
    private Date releaseDate;
    private int hoursInAir;
    private int id;

    public Plane() {}
    public Plane(String name, Date releaseDate, int hoursInAir) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.hoursInAir = hoursInAir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getHoursInAir() {
        return hoursInAir;
    }

    public void setHoursInAir(int hoursInAir) {
        this.hoursInAir = hoursInAir;
    }


}
