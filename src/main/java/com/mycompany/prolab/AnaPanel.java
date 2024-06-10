
package com.mycompany.prolab;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


class BirdNode {
    private int x;
    private int y;
    private int direction; 
    private int step; 

    public BirdNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 1; 
        this.step = 1; 
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}




class BeeNode {
    
    private int direction;
    private int step; 
private int x;
    private int y;
    public BeeNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = -1; 
        this.step = 1; 
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}


public class AnaPanel extends JPanel{
    int genislik=1000;
    int yukseklik=1000;
    int kareboyut;
    int karepikselligi;
    public Image agac;
    public Image kaya;
    public Image altinsandik;
    public Image gümüssandik;
    public Image zümrütsandik;
    public Image bakirsandik;
    SabitEngeller sbtengeller;
    HareketliEngeller hareketliengeller;
    Engeller engeller;
    public Image yazagac;
    public Image yazkaya;
    public int konummatris[][];
    public int boyut[][];
    public int konum[][];
    public ArrayList<Node> agackoordinat;
    public ArrayList<Node> sandikkoordinat;
    public ArrayList<Node> kayakoordinat;
    public ArrayList<Node> duvarkoordinat;
    public ArrayList<Node> kisagackoordinat;
    public ArrayList<Node> kiskayakoordinat;
    public ArrayList<Node> kisduvarkoordinat;
    public ArrayList<Node> kisdagkoordinat;
    public ArrayList<Node> yazdagkoordinat;
    public ArrayList<Node> coordinates;
    public ArrayList<Node> birdkoordinat;
    public ArrayList<Node> beekoordinat;
    public ArrayList<BirdNode> birdkoordinatbirdnode;
    public ArrayList<BeeNode> beekoordinatbeenode;
     
       ArrayList<Node> kusHareketListesi = new ArrayList<>();
       ArrayList<Node> ariHareketListesi = new ArrayList<>();
    public int en;
    public int boy;
    public int a;
    public int b;
    public int m;
    public int e;
    private Kus kus;
    private Ari ari;
    private Duvar duvar;
    private Kaya kayaa;
    private Agac agacc;
    private Dag dagg;
    private Timer birdTimer;
    private Timer beeTimer;
    
    private Timer animasyontimer;
    private int currentIndex = 0;
    
    static ArrayList<Node> yol;
    
    public AnaPanel(int kareboyut){
        
        this.kareboyut=kareboyut;
        this.karepikselligi= genislik/this.kareboyut;
        this.setPreferredSize(new Dimension (genislik,yukseklik));
        
        this.setBackground(Color.gray);
        
        this.altinsandik = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/altinsandik.png").getImage();
        this.gümüssandik = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/gümüşsandik.png").getImage();
        this.bakirsandik = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/bakirsandik.png").getImage();
        this.zümrütsandik = new ImageIcon("/Users/melisportakal/desktop/Prolab.vsoneksikmi/src/main/java/resimler/zümrütsandik.png").getImage();
        this.sbtengeller = new SabitEngeller(boyut, konum,agac,kaya); 
        this.hareketliengeller = new HareketliEngeller(boyut, konum); 
        this.engeller = new Engeller(boyut,konum);
        agackoordinat = new ArrayList<>();
        sandikkoordinat=new ArrayList<>();
        kayakoordinat=new ArrayList<>();
        duvarkoordinat=new ArrayList<>();
        kisduvarkoordinat=new ArrayList<>();
        kiskayakoordinat=new ArrayList<>();
        kisagackoordinat=new ArrayList<>();
        coordinates = new ArrayList<>();
        birdkoordinat = new ArrayList<>();
        beekoordinat = new ArrayList<>();
        this.kisdagkoordinat = new ArrayList<>();
        this.yazdagkoordinat = new ArrayList<>();
        birdkoordinatbirdnode = new ArrayList<BirdNode>();
        beekoordinatbeenode = new ArrayList<BeeNode>();
        this.konummatris=new int[kareboyut][kareboyut];
        en = 2;
        boy = 2;
         kus = new Kus(boyut,konum,en,boy);
         ari = new Ari(boyut,konum,en,boy);
         kayaa = new Kaya(boyut,konum,en,boy,a,b);
         duvar = new Duvar(boyut,konum,en,boy,a,b);
         agacc = new Agac(boyut,konum,en,boy);
         dagg = new Dag(boyut,konum,en,boy);
         
  
        randomsayi();
        
        int sayi1=0,sayi2=0;
        int i=0;
        while(i<1){
            Random location=new Random();
            sayi1=location.nextInt(kareboyut);
            sayi2=location.nextInt(kareboyut);
            if(konummatris[sayi1][sayi2]!=1){
                i++;
            }
        }
        
        Node karakter = new Node(sayi1,sayi2);
        
        
        AStarAlgorithm a = new AStarAlgorithm(konummatris,sandikkoordinat,kareboyut,karakter);
        yol= new ArrayList<>();
        yol=a.dondur();
       
       animasyontimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                currentIndex++;
                if (currentIndex >= yol.size()) {
                    animasyontimer.stop(); 
                }
            }
        });
        animasyontimer.start();
     
   
    
        birdTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBirds();
                repaint();
            }
        });
        birdTimer.start(); 

        
        beeTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               moveBees();
                repaint(); 
            }
        });
        beeTimer.start(); 
    }
    
    
    private void moveBirds() {
    for (BirdNode bird : birdkoordinatbirdnode) {
        
        int step = bird.getDirection();

      
        int currentY = bird.getY();
        int newY = currentY + step;

        
        int currentStep = bird.getStep();
        if (currentStep == 4) {
            
            bird.setDirection(-step);
            bird.setStep(1); 
        } else {
            
            bird.setStep(currentStep + 1);
        }

        
        if (newY < 0) {
            newY = 0; 
        } else if (newY >= kareboyut) {
            newY = kareboyut - 1; 
        }
        
        
        if (newY >= 0 && newY < kareboyut) {
            Node newCoordinate = new Node(bird.getX(), newY);
                
                coordinates.add(newCoordinate);
                kusHareketListesi.add(new Node(bird.getX(), newY));
               
                
              
        }
        

        bird.setY(newY);
       
    }
}

    
 



 private void moveBees() {
    for (BeeNode bee : beekoordinatbeenode) {
        
        
        
        int step = bee.getDirection();

        
        int currentX = bee.getX();
        int newX = currentX + step;

        
        int currentStep = bee.getStep();
        if (currentStep == 2) {
            
            bee.setDirection(-step);
            bee.setStep(1); 
        } else {
            
           
            bee.setStep(currentStep + 1);
        }

        
        if (newX < 0) {
            newX = 0; 
        } else if (newX >= kareboyut) {
            newX = kareboyut - 1; 
        }
        
        
        if (newX >= 0 && newX < kareboyut) {
            Node newCoordinate = new Node(newX, bee.getY());
                
                coordinates.add(newCoordinate);
                 ariHareketListesi.add(new Node(newX, bee.getY()));
               konummatris[newX][bee.getY()] = 1;
            
        }

        bee.setX(newX);
    }
}



    


    
   
       
    
    
    public void randomsayi(){
        
   int i = 0;
while (i < 5) {
    Random rastgele = new Random();
    
    int x = rastgele.nextInt(kareboyut / 2) + kareboyut / 2;
    int y = rastgele.nextInt(kareboyut);
    Node yenik = new Node(x, y);
    
    boolean uygunKonum = true;
    
    
    for (int v = x; v < x + 3 && uygunKonum; v++) {
        for (int s = y; s < y + 3 && uygunKonum; s++) {
            
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
   
    if (!uygunKonum) {
        continue;
    }
    
   
    for (int v = x; v < x + 3; v++) {
        for (int s = y; s < y + 3; s++) {
            konummatris[s][v] = 1; 
        }
    }
    
    
    agackoordinat.add(yenik);
    coordinates.add(yenik);
    
    i++;
}      
           
     int k = 0;
     while(k < 3)
     {   
          Random rastgele = new Random();
            int x = rastgele.nextInt(kareboyut / 2) + kareboyut / 2;
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            
            
            
            
            boolean uygunKonum = true;
    
   
    for (int v = x; v < x + 3 && uygunKonum; v++) {
        for (int s = y; s < y + 3 && uygunKonum; s++) {
            
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
    
    if (!uygunKonum) {
        continue;
    }
    

    for (int v = x; v < x + 3; v++) {
        for (int s = y; s < y + 3; s++) {
           
            konummatris[s][v] = 1; 
            
        }
    }
    
   
    kayakoordinat.add(yenik);
    coordinates.add(yenik);
    
    k++;        
         
     }
   
     
     int m = 0;
     while(m < 4)
     {   
         Random rastgele = new Random();
            int x = rastgele.nextInt(kareboyut / 2) + kareboyut / 2;
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            boolean uygunKonum = true;
    
    
    for (int v = x; v < x + 1 && uygunKonum; v++) {
        for (int s = y; s < y + 10 && uygunKonum; s++) {
            
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 1; v++) {
        for (int s = y; s < y + 10; s++) {
           
            konummatris[s][v] = 1; 
            
        }
    }
   
    duvarkoordinat.add(yenik);
    coordinates.add(yenik);
    
    m++;

            }
     
     
     
     int a = 0;
     while(a < 4)
     {   
         Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut / 2);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            
            boolean uygunKonum = true;
   
    for (int v = x; v < x + 3 && uygunKonum; v++) {
        for (int s = y; s < y + 3 && uygunKonum; s++) {
            
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false;
            }
        }
    }
    
    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 3; v++) {
        for (int s = y; s < y + 3; s++) {
           
            konummatris[s][v] = 1; 
            
        }
    }
    
    kisagackoordinat.add(yenik);
    coordinates.add(yenik);
    
    a++;
        }
     
     
     int c = 0;
     while(c < 4)
     {  
         Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut / 2);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            boolean uygunKonum = true;
    
    for (int v = x; v < x + 10 && uygunKonum; v++) {
        for (int s = y; s < y + 1 && uygunKonum; s++) {
            
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 10; v++) {
        for (int s = y; s < y + 1; s++) {
           
            konummatris[s][v] = 1; 
           
        }
    }
   
    kisduvarkoordinat.add(yenik);
    coordinates.add(yenik);
    
    c++;

            
        }
     
     int q = 0;
     while(q < 4)
     {  
         Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut/2);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            boolean uygunKonum = true;
    
    for (int v = x; v < x + 2 && uygunKonum; v++) {
        for (int s = y; s < y + 2 && uygunKonum; s++) {
        
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 2; v++) {
        for (int s = y; s < y + 2; s++) {
           
            konummatris[s][v] = 1; 
           
        }
    }
    
    kiskayakoordinat.add(yenik);
    coordinates.add(yenik);
    
    q++;

            
        }
     int p = 0;
     while(p < 2)
     { 
         Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut / 2);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            boolean uygunKonum = true;
    
    for (int v = x; v < x + 15 && uygunKonum; v++) {
        for (int s = y; s < y + 15 && uygunKonum; s++) {
    
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    
    if (!uygunKonum) {
        continue;
    }

    for (int v = x; v < x + 15; v++) {
        for (int s = y; s < y + 15; s++) {
           
            konummatris[s][v] = 1;
           
        }
    }
   
    kisdagkoordinat.add(yenik);
    coordinates.add(yenik);
    
    p++;

            
        }
     
     int r = 0;
     while(r < 2)
     {  
         Random rastgele = new Random();
            int x = rastgele.nextInt(kareboyut / 2) + kareboyut / 2;
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            boolean uygunKonum = true;
    
    for (int v = x; v < x + 15 && uygunKonum; v++) {
        for (int s = y; s < y + 15 && uygunKonum; s++) {
   
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false;
            }
        }
    }

    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 15; v++) {
        for (int s = y; s < y + 15; s++) {
           
            konummatris[s][v] = 1;
            
        }
    }

    yazdagkoordinat.add(yenik);
    coordinates.add(yenik);
    
    r++;

     }
     
     
     
     int t = 0;
     while(t < 2)
     { 
          Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            BirdNode bird = new BirdNode(yenik.getX(), yenik.getY());
             boolean uygunKonum = true;
    
    for (int v = x; v < x + 2 && uygunKonum; v++) {
        for (int s = y; s < y + 5 && uygunKonum; s++) {
 
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
   
    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 2; v++) {
        for (int s = y; s < y + 5; s++) {
           
            konummatris[s][v] = 1; 
            
            
        }
    }
    
    birdkoordinat.add(yenik);
    birdkoordinatbirdnode(yenik);
    coordinates.add(yenik);
    
    t++;

            
    }

            
     
     int z = 0;
     while(z < 1)
     {
          Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
            BeeNode bee = new BeeNode(yenik.getX(), yenik.getY());
             boolean uygunKonum = true;
    
    for (int v = x; v < x + 3 && uygunKonum; v++) {
        for (int s = y; s < y + 2 && uygunKonum; s++) {

            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }

    if (!uygunKonum) {
        continue;
    }
    
    for (int v = x; v < x + 3; v++) {
        for (int s = y; s < y + 2; s++) {
           
            konummatris[s][v] = 1; 
            
            
        }
    }
    
    beekoordinat.add(yenik);
    beekoordinatbeenode(yenik);
    coordinates.add(yenik);
    
    z++;

     }
     
      int j=0;
      while (j<4){
          Random rastgele = new Random();
            int x= rastgele.nextInt(kareboyut);
            int y=rastgele.nextInt(kareboyut);
            Node yenik= new Node(x,y);
             boolean uygunKonum = true;
          
          
          for (int v = x; v < x + 1 && uygunKonum; v++) {
        for (int s = y; s < y + 1 && uygunKonum; s++) {
           
            if (v < 0 || v >= kareboyut || s < 0 || s >= kareboyut || konummatris[s][v] == 1) {
                uygunKonum = false; 
            }
        }
    }
    

    if (!uygunKonum) {
        continue;
    }
   
    for (int v = x; v < x + 1; v++) {
        for (int s = y; s < y + 1; s++) {
           
            konummatris[s][v] = 0; 
        }
    }

    sandikkoordinat.add(yenik);
    coordinates.add(yenik);
    
    j++;  
      }

    
    }
    
    @Override
   public void paintComponent(Graphics g) {
       
       super.paintComponent(g);
        
       
       int width = getWidth();
    int height = getHeight();
    

    Color solRenk = new Color(255, 255, 255); 
    

    Color sagRenk = new Color(144, 238, 144);
    
    GradientPaint gradient = new GradientPaint(0, 0, solRenk, width, 0, sagRenk);
   
    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(gradient);
    g2d.fillRect(0, 0, width, height);
    izgaraciz(g2d);
       
       
    g.setColor(Color.RED);
    for (Node node : kusHareketListesi) {
        int x = node.getX() * karepikselligi;
        int y = node.getY() * karepikselligi;
        g.fillRect(x, y, kus.en*karepikselligi, kus.boy*karepikselligi);
    }

    for (Node node : ariHareketListesi) {
        int x = node.getX() * karepikselligi;
        int y = node.getY() * karepikselligi;
        g.fillRect(x, y, ari.boy*karepikselligi, ari.en*karepikselligi);
    }
    
    
    
    
      for(int i =0 ; i<3;i++){
         Node nokta = agackoordinat.get(i);
            g.drawImage(sbtengeller.yazagac,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,agacc.en*karepikselligi,agacc.boy*karepikselligi,null);
        }
      for(int i =0 ; i < 3;i++){
         Node nokta = kayakoordinat.get(i);
            g.drawImage(sbtengeller.yazkaya,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,kayaa.en*karepikselligi,kayaa.boy*karepikselligi,null);
      }
      
      for(int i =0 ; i<3;i++){
         Node nokta = duvarkoordinat.get(i);
            g.drawImage(sbtengeller.yazduvar,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,duvar.yazen*karepikselligi,duvar.yazboy*karepikselligi,null);
        }
      for(int i =0 ; i<4;i++){
         Node nokta = kisagackoordinat.get(i);
            g.drawImage(sbtengeller.kisagac,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,agacc.en*karepikselligi,agacc.boy*karepikselligi,null);
        }
       for(int i =0 ; i<4;i++){
         Node nokta = kisduvarkoordinat.get(i);
            g.drawImage(sbtengeller.kisduvar,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,duvar.en*karepikselligi,duvar.boy*karepikselligi,null);
        }
       for(int i =0 ; i<4;i++){
         Node nokta = kiskayakoordinat.get(i);
            g.drawImage(sbtengeller.kiskaya,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,kayaa.kisen*karepikselligi,kayaa.kisboy*karepikselligi,null);
        }
       for(int i =0 ; i<2;i++){
         Node nokta = kisdagkoordinat.get(i);
            g.drawImage(sbtengeller.kisdag,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,dagg.en*karepikselligi,dagg.boy*karepikselligi,null);
        }
      
       for(int i =0 ; i<2;i++){
         Node nokta = yazdagkoordinat.get(i);
            g.drawImage(sbtengeller.yazdag,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,dagg.en*karepikselligi,dagg.boy*karepikselligi,null);
        }
      
       
       
       
        for (int i = 0; i < birdkoordinatbirdnode.size(); i++) {
            BirdNode bird = birdkoordinatbirdnode.get(i);
             if (coordinates.contains(new Node(bird.getX(), bird.getY()))) {
                 g.setColor(Color.RED); // Yörünge rengi kırmızı
                  g.fillOval(bird.getX() * karepikselligi, bird.getY() * karepikselligi, kus.en * karepikselligi, kus.boy * karepikselligi); // Kırmızı yörüngeyi doldur
           
             }
            g.drawImage(hareketliengeller.bird, bird.getX()*karepikselligi,bird.getY()*karepikselligi,kus.en*karepikselligi,kus.boy*karepikselligi, null);
        }
       
       for(int i =0 ; i<beekoordinatbeenode.size();i++){
         
         BeeNode bee = beekoordinatbeenode.get(i);
         g.drawImage(hareketliengeller.bee,bee.getX()*karepikselligi,bee.getY()*karepikselligi,ari.en*karepikselligi,ari.boy*karepikselligi,null);
       }
       
      for(int i =0 ; i<1;i++){
         Node nokta = sandikkoordinat.get(i);
            g.drawImage(altinsandik,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,karepikselligi,karepikselligi,null);
        }
      for(int i =1 ; i<2;i++){
         Node nokta = sandikkoordinat.get(i);
            g.drawImage(gümüssandik,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,karepikselligi,karepikselligi,null);
        }
      for(int i =2 ; i<3;i++){
         Node nokta = sandikkoordinat.get(i);
            g.drawImage(bakirsandik,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,karepikselligi,karepikselligi,null);
        }
      for(int i =3 ; i<4;i++){
         Node nokta = sandikkoordinat.get(i);
            g.drawImage(zümrütsandik,nokta.getX()*karepikselligi,nokta.getY()*karepikselligi,karepikselligi,karepikselligi,null);
        }
      
      for (int i = 0; i < currentIndex; i++) {
            g.setColor(Color.GREEN);
            g.fillRect(yol.get(i).getX() * karepikselligi,yol.get(i).getY() * karepikselligi, karepikselligi, karepikselligi);
        }

    }
   
   
    
    public void izgaraciz(Graphics g) {
        for(int i = 0; i < kareboyut; i++) {
            g.drawLine(i*karepikselligi, 0, i*karepikselligi, yukseklik);
            g.drawLine(0, i*karepikselligi, genislik, i*karepikselligi); 
            
        }
          
    }
    
    public void izgaraciz(Graphics2D g) {
    g.setColor(Color.DARK_GRAY); // Izgara rengi
    for (int i = 0; i < kareboyut; i++) {
        g.drawLine(i * karepikselligi, 0, i * karepikselligi, yukseklik);
        g.drawLine(0, i * karepikselligi, genislik, i * karepikselligi);
    }
}


    private void izgaraciz() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void birdkoordinatbirdnode(Node node) {

    BirdNode birdNode = new BirdNode(node.getX(), node.getY());

    birdkoordinatbirdnode.add(birdNode);
    
}
private void beekoordinatbeenode(Node node) {

    BeeNode beeNode = new BeeNode(node.getX(), node.getY());
    
    beekoordinatbeenode.add(beeNode);
}
}
