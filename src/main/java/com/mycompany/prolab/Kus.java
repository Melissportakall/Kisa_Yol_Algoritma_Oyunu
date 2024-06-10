/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

/**
 *
 * @author melisportakal
 */
public class Kus extends HareketliEngeller{
    public int en;
    public int boy;
    public Kus(int boyut[][], int konum[][],int en,int boy)
    {
        super(boyut,konum);
        this.en = en; 
        this.boy = boy; 
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
