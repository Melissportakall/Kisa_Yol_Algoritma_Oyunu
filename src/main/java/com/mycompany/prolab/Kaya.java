/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

/**
 *
 * @author melisportakal
 */
public class Kaya extends Engeller{
    private int[][] boyut;
    private int[][] konum;
    public int en;
    public int boy;
    public int kisboy;
    public int kisen;
    public Kaya(int[][] boyut,int[][] konum,int en,int boy,int kisboy,int kisen)
    {
        super(boyut,konum);
        this.en = 3;
        this.boy = 3;  
        this.kisboy = 2;
        this.kisen = 2;
        
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
      public void setkisen(int kisen)
    {
        this.kisen = kisen;
    }
    
    public int getkisen()
    {
        return kisen;
    }
    public void setkisboy(int kisboy)
    {
        this.kisboy = kisboy;
    }
    
    public int getkisboy()
    {
        return kisboy;
    }
}
