/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prolab;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author melisportakal
 */
public class HareketliEngeller extends Engeller{
    private int boyut[][];
    private int konum[][];
    public Image bird;
    public Image bee;
    
    public HareketliEngeller(int boyut[][], int konum[][])
    {
        super(boyut,konum);
        this.bee = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/bee.png").getImage();
        this.bird = new ImageIcon("Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/bird.png").getImage();
        
    }
    
    
}
