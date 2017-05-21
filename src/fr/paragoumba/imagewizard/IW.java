package fr.paragoumba.imagewizard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Paragoumba on 16/05/2017.
 */

public class IW {

    private static BufferedImage square;
    private static BufferedImage finalImage;

    public static void main(String[] args) throws IOException {

        /*Scanner scanner = new Scanner(System.in);
        long time = System.currentTimeMillis();

        /*try {
            FileInputStream fis = new FileInputStream("C:/Users/parag/Desktop/carre.png");
            square = ImageIO.read(fis);
            fis.close();
        } catch (IOException e) {e.printStackTrace();}*/

        //makeFractal()
        /*int width = 1920;
        int height = 1080;
        int startX = 960;
        int startY = 540;
        Color backgroundColor = new Color(0, 255, 0);
        Color mainColor = new Color(0, 0, 255);
        Color accentuationColor = new Color(31, 31, 31);
        int iterations = 10000000;
        boolean putJustSomeMagicPlease = scanner.nextBoolean();
        ImageIO.write(Fractals.makeFractal(width, height, startX, startY, backgroundColor, mainColor, accentuationColor, iterations, putJustSomeMagicPlease), "png", new File("D:/Bureau/fractals/fractal" + width + "x" + height + (putJustSomeMagicPlease ? "" : "" + startX + startY + backgroundColor.getRGB() + mainColor.getRGB()) + accentuationColor.getRGB() + iterations + ".png"));

        //makeSpecialFractal()
        //ImageIO.write(makeSpecialFractal(ImageIO.read(new File("D:/Bureau/fractals/Sans titre.png")), new Color(0, 255, 255), new Color(221, 221, 34), 1000), "png", new File("D:/Bureau/fractals/fractalpattern.png"));

        //testColor()
        /*BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, 80, 80);
        g2d.setColor(Color.blue);
        g2d.fillRect(10, 10, 20, 20);
        g2d.setColor(Color.cyan);
        g2d.fillArc(30, 30, 10, 10, 0, 360);
        g2d.dispose();

        testColor(image, Color.cyan);*/

        /*System.out.println("Execution time : " + (System.currentTimeMillis() - time) + "ms.");*/



        BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, 80, 80);
        g2d.setColor(Color.BLUE);
        g2d.drawString("y", 5, 5);

        ImageIO.write(image, "png", new File("D:/Bureau/x.png"));
    }
}
