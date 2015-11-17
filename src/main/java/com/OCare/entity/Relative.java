package com.OCare.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fowafolo on 15/7/26.
 */
@Entity
@Table
public class Relative {

    @Id
    private String id;
    private String name;
    private String phone;
    private String address;
    private String password;
    private String image;

//    public List<ElderMonitor> getElderMonitors() {
//        return elderMonitors;
//    }
//
//    public void setElderMonitors(List<ElderMonitor> elderMonitors) {
//        this.elderMonitors = elderMonitors;
//    }

//    @OneToMany(mappedBy = "relative")
//    private List<ElderMonitor> elderMonitors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
