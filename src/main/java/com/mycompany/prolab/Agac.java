/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

/**
 *
 * @author melisportakal
 */
public class Agac extends Engeller{
    private int[][] boyut;
    private int[][] konum;
    public int en;
    public int boy;
   
    public Agac(int[][] boyut,int[][] konum,int en,int boy)
    {
        super(boyut,konum);
        this.en = 3;
        this.boy = 3;  
        
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
