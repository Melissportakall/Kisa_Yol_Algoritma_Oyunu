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
public class SabitEngeller extends Engeller{
    private int[][] boyut;
    private int[][] konum;
    public Image yazagac;
    public Image yazkaya;
    public Image yazduvar;
    public Image kisagac;
    public Image kiskaya;
    public Image kisduvar;
    public Image yazdag;
    public Image kisdag;

    public SabitEngeller(int [][]boyut,int [][] konum,Image agac,Image kaya)
    {
        super(boyut,konum);
        this.yazdag = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/yazengelleri/yazdag.png").getImage();
        this.yazagac = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/yazengelleri/yazagac.png").getImage();
        this.yazkaya = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/yazengelleri/yazkaya.png").getImage();
        this.yazduvar = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/yazengelleri/yazduvar.png").getImage();
        this.kisagac = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/kisengelleri/kisagac.png").getImage();
        this.kiskaya = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/kisengelleri/kiskaya.png").getImage();
        this.kisduvar = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/kisengelleri/kisduvar.png").getImage();
        this.kisdag = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/kisengelleri/kisdag.png").getImage();
        
    }
    
}
