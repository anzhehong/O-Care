package com.OCare.entity;

import javax.persistence.*;

/**
 * Created by fowafolo on 15/7/30.
 */

@Entity
@Table
public class ElderMonitor {

    @Id
    private int id;

    //private String relative_id;
    //2表示监护类型为普通亲戚；1表示监护类型为监护人；3表示在申请监护人;
    //4表示申请监护人被拒绝;5代表邻居关系;
    //7.代表原来有关系现在没关系了
    private int type;
    private String togetherImg;


    @ManyToOne(optional=false)
    @JoinColumn(name = "elder_id", referencedColumnName = "id")
    private Elder elder;

    @ManyToOne(optional=false)
    @JoinColumn(name = "relative_id", referencedColumnName = "id")
    private Relative relative;

//    public Elder getElder() {
//        return elder;
//    }
//
//    public void setElder(Elder elder) {
//        this.elder = elder;
//    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
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

    public void setElder_id(String elder_id) {
        this.elder.setId(elder_id);
    }

//    public String getRelative_id() {
//        return relative_id;
//    }
//
//    public void setRelative_id(String relative_id) {
//        this.relative_id = relative_id;
//    }

    public String getRelative_id() {
        return relative.getId();
    }

    public void setRelative_id(String relative_id) {
        this.relative.setId(relative_id);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTogetherImg() {
        return togetherImg;
    }

    public void setTogetherImg(String togetherImg) {
        this.togetherImg = togetherImg;
    }
}
