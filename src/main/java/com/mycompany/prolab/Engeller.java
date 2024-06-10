/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

/**
 *
 * @author melisportakal
 */
public class Engeller {
    private int[][] boyut;
    private int[][] konum;
    public Engeller(int [][]boyut,int [][] konum)
    {
        this.boyut = boyut;
        this.konum = konum;
        
            
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
}
