package fr.paragoumba.imagewizard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Paragoumba on 16/05/2017.
 */

public class IW {

    private static BufferedImage square;
    private static BufferedImage finalImage;

    public static void main(String[] args) throws IOException {

        long time = System.currentTimeMillis();

        try {
            FileInputStream fis = new FileInputStream("C:/Users/parag/Desktop/carre.png");
            square = ImageIO.read(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIO.write(makeFractal(1920, 1080, 1920 / 2, 1080 / 2,
                new Color(255, 255, 255), new Color(254, 254, 254), new Color(0, 0, 0), 10000000),
                "png", new File("C:/Users/parag/Desktop/fractals/fractalwb.png"));

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

        System.out.println("Execution time : " + (System.currentTimeMillis() - time) + "ms.");
    }

    private static BufferedImage repeatPattern(int width, int height, BufferedImage pattern){

        BufferedImage image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        for (int x = 0 ; x < width - pattern.getWidth() + 1 ; x+=pattern.getWidth()) {
            for (int y = 0 ; y < height - pattern.getHeight() + 1 ; y+=pattern.getHeight()) {
                g2d.drawImage(square, x, y, null);
            }
        }

        g2d.dispose();

        return image;
    }

    private static BufferedImage makeFractal(int width, int height, int startX, int startY, Color backgroundColor, Color mainColor, Color accentuationColor, int iterations) {

        Random random = new Random();

        System.out.println("Creating the fractal...");

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(mainColor);

        for (int i = 0 ; i < iterations ; i++){

            g2d.fillRect(startX, startY, 1, 1);

            System.out.println("x : " + startX + ", y : " + startY);

            int n = random.nextInt(4 + 1);

            if (n == 0 && startX + 1 < width){
                startX++;
            } else if (n == 1 && startX - 1 >= 0){
                startX--;
            } else if (n == 2 && startY + 1 < height){
                startY++;
            } else if (n == 3 && startY - 1 >= 0){
                startY--;
            }
        }

        g2d.dispose();

        System.out.println("Fractal finished, magic incoming. ;)");

        image = improveAFractalMagically(image, mainColor, backgroundColor, accentuationColor);

        return image;
    }

    private static BufferedImage improveAFractalMagically(BufferedImage image, Color mainColor, Color backgroundColor, Color accentuationColor) {

        int width = image.getWidth();
        int height = image.getHeight();

        System.out.println("Entering Magical World.");

        for (int w = 0 ; w < width ; w++){
            for (int h = 0 ; h < height ; h++){

                Graphics2D g2d;

                if (image.getRGB(w, h) == mainColor.getRGB()){
                    if ((w + 1 < width && image.getRGB(w+1, h) == backgroundColor.getRGB()) || (w - 1 >= 0 && image.getRGB(w-1, h) == backgroundColor.getRGB()) || (h + 1 < height && image.getRGB(w, h+1) == backgroundColor.getRGB()) || (h - 1 >= 0 && image.getRGB(w, h-1) == backgroundColor.getRGB())){

                        g2d = (Graphics2D) image.getGraphics();
                        g2d.setColor(accentuationColor);
                        g2d.fillRect(w, h, 1, 1);
                        System.out.println("Setting pixel.");
                        g2d.dispose();
                    }
                } else {
                    System.out.println("No pixel for you.");
                }
            }
        }

        System.out.println("Magic has ended, returning to overworld.");

        return image;
    }

    private static void testColor(BufferedImage image, Color color){

        StringBuilder result = new StringBuilder();

        for (int w = 0 ; w < image.getWidth() ; w++){
            for (int h = 0 ; h < image.getHeight() ; h++){
                if (image.getSubimage(w, h, 1, 1).getRGB(0, 0) == -16776961){
                    result.append("\u25A0");
                } else if (image.getSubimage(w, h, 1, 1).getRGB(0, 0) == -16711681){
                    result.append("\u28A0");
                } else {
                    result.append("\u25A1");
                }
            }

            result.append("\n");
        }

        System.out.println(result);
    }
}
