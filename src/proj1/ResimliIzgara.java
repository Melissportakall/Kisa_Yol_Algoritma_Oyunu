import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ResimliIzgara extends JPanel {

    private Image resim;
    private int boyut;
    private int[][] izgara;
    private int randomX;
    private int randomY;

    public ResimliIzgara(int boyut) {
        this.boyut = boyut;
        izgara = new int[boyut][boyut];
        loadResim();
        generateRandomCoordinates();
    }

    private void loadResim() {
        ImageIcon icon = new ImageIcon("/Users/melisportakal/desktop/a.jpg");
        resim = icon.getImage();
    }

    private void generateRandomCoordinates() {
        Random random = new Random();
        randomX = random.nextInt(boyut);
        randomY = random.nextInt(boyut);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth(), getHeight()) / boyut;

        // İzgarayı çiz
        for (int x = 0; x < boyut; x++) {
            for (int y = 0; y < boyut; y++) {
                int startX = x * cellSize;
                int startY = y * cellSize;
                g.drawRect(startX, startY, cellSize, cellSize); // Karelerin sınırlarını çiz
                if (x == randomX && y == randomY) { // Rastgele seçilen kareye resmi çiz
                    g.drawImage(resim, startX, startY, cellSize, cellSize, null);
                }
            }
        }
    }
}
