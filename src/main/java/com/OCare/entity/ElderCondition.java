package com.OCare.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fowafolo on 15/7/26.
 */
@Entity
@Table
public class ElderCondition {
    @Id
    private int id;


    private int status;
    private double latitude;
    private double longtitude;
    private Date time;

    @ManyToOne(optional=false)
    @JoinColumn(name = "elder_id", referencedColumnName = "id")
    private Elder elder;




    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElder_id() {
        return elder.getId();
    }

    public void setElder_id(String elder_id){ this.elder.setId(elder_id);}


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
