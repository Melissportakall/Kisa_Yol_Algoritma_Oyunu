/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

/**
 *
 * @author melisportakal
 */
public class Duvar extends Engeller {
    private int[][] boyut;
    private int[][] konum;
    public int en;
    public int boy;
    public int yazen;
    public int yazboy;
    public Duvar(int[][] boyut,int[][] konum,int en,int boy,int yazen,int yazboy)
    {
        super(boyut,konum);
        this.en = 10;
        this.boy = 1;  
        this.yazboy = 10;
        this.yazen = 1;
    }
     

    public void setboyut(int[][] boyut)
    {
        this.boyut = boyut;
    }
    
    public int[][] getboyut()
    {
        return boyut;
    }
    
    public void setkonum(int [][] konum)
    {
        this.konum = konum;
    }
    
    public int[][] getkonum()
    {
        return konum;
    }
      public void seten(int en)
    {
        this.en = en;
    }
    
    public int geten()
    {
        return en;
    }
    public void setboy(int boy)
    {
        this.boy = boy;
    }
    
    public int getboy()
    {
        return boy;
    }
}
