/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

import java.util.Random;

/**
 *
 * @author melisportakal
 */
import java.util.Random;

public class Karakter extends Lokasyon {
    public String ad;
    public int ID;

    public Karakter(int x, int y, String ad, int ID) {
        super(x, y);
        this.ad = ad;
        this.ID = ID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRastgeleID() {
        Random random = new Random();
        this.ID = random.nextInt(100000) + 1;
    }
}
