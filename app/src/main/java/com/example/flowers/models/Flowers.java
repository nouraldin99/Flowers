package com.example.flowers.models;

import java.io.Serializable;

public class Flowers implements Serializable {
    private int id;
    private String img ;
    private String tittle;
    private String des;
    private double price ;
    private int rate;

    public Flowers(int id,String img, String tittle, String des,double price, int rate) {
        this.id = id;
        this.img = img ;
        this.tittle = tittle;
        this.des = des;
        this.price = price;
        this.rate = rate;
    }

    public Flowers(String img,String tittle, String des, double price ,int rate) {
        this.img = img ;
        this.tittle = tittle;
        this.des = des;
        this.price = price;
        this.rate = rate;
    }

    public Flowers(int id,String img, String tittle, String des) {
        this.id = id;
        this.img = img ;
        this.tittle = tittle;
        this.des = des;
    }

    public Flowers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
