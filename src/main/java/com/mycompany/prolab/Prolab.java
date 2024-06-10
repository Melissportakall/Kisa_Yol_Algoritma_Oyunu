package com.mycompany.prolab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prolab {

    private static AnaPanel anapanel;
    private Karakter karakterr;
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        int kareboyut = Integer.parseInt(JOptionPane.showInputDialog("Koordinat düzleminin boyutunu girin:"));
        String charactername = JOptionPane.showInputDialog("Karakterin ismini girin:");
        Karakter karakterr = new Karakter(0, 0, charactername, 0);
        karakterr.setRastgeleID();
        JFrame pencere = new JFrame();
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setResizable(false);
        pencere.setSize(1000, 1000);
      pencere.setTitle("Karakter Adı: " + karakterr.getAd() + " ID: " + karakterr.getID());
         pencere.setLocationRelativeTo(null);
        pencere.setLocationRelativeTo(null);

        
        anapanel = new AnaPanel(kareboyut);
        pencere.add(anapanel);

        pencere.pack();
        pencere.setVisible(true);

        
        JPanel checkBoxPanel = new JPanel();
        JCheckBox checkBox1 = new JCheckBox("Yeniden Harita Oluştur");
        JCheckBox checkBox2 = new JCheckBox("Başlat");
        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);

        pencere.add(checkBoxPanel, BorderLayout.NORTH);

        
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Harita Yeniden Oluşturuldu.\n");
                    
                    pencere.remove(anapanel); 
                    anapanel = new AnaPanel(kareboyut); 
                    pencere.add(anapanel); 
                    pencere.revalidate();
                    pencere.repaint();
                }
                
            }
        });

        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox2.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Proje Başlatılıyor.\n");
                    
                }
            }
        });
    }
}
