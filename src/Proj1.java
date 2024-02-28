import javax.swing.*;
import java.awt.*;
import java.util.Random;
//import proj1.ResimliIzgara;



public class Proj1 extends JFrame {

    private int boyut;

    public Proj1(int boyut) {
        this.boyut = boyut;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Koordinat Düzlemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int maxWidth = 800;
        int maxHeight = 600;
        int width = Math.min(boyut * 50, maxWidth);
        int height = Math.min(boyut * 50, maxHeight);
        setSize(width, height);
        setLocationRelativeTo(null);

        // Resimli izgarayı oluştur ve ekle
        ResimliIzgara izgaraPanel = new ResimliIzgara(boyut);
        add(izgaraPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int boyut = Integer.parseInt(JOptionPane.showInputDialog("Koordinat düzleminin boyutunu girin:"));
            new Proj1(boyut).setVisible(true);
           
        });
    }


}
