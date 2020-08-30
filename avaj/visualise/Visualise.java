package avaj.visualise;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Visualise {

    private Graphics2D g;
    private BufferedImage bufferedImage;

    public Visualise() {
        bufferedImage = new BufferedImage(4096, 500, BufferedImage.TYPE_INT_RGB);
        g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, 4096, 500);
        drawGrid();
    }

    public void test() {
        System.out.println("Test!");
    }

    public void drawGrid() {
        for (int y = 50; y <= 450; y += 25) {
            //System.out.println(y);
            g.setColor(Color.lightGray);
            g.drawLine(50, y, 4046, y);
        }

        g.setColor(Color.black);
        g.drawString("0", 35, 450);
        g.drawString("50", 25, 250);
        g.drawString("100", 25, 50);

    }

    public void drawInitialAircraft(int lng, int lat, int height) {
        g.setColor(Color.black);
        g.drawOval(lng + 100, height, lat, lat);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        g.setColor(Color.black);
        g.drawLine(x1, y1, x2, y2);
    }

    public void saveImage() throws IOException {
        File file = new File("simulation.png");
        ImageIO.write(bufferedImage, "png", file);
    }
}
