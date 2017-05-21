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

        Scanner scanner = new Scanner(System.in);
        long time = System.currentTimeMillis();

        /*try {
            FileInputStream fis = new FileInputStream("C:/Users/parag/Desktop/carre.png");
            square = ImageIO.read(fis);
            fis.close();
        } catch (IOException e) {e.printStackTrace();}*/

        //makeFractal()
        int width = 1920;
        int height = 1080;
        int startX = 960;
        int startY = 540;
        Color backgroundColor = new Color(0, 255, 0);
        Color mainColor = new Color(0, 0, 255);
        Color accentuationColor = new Color(31, 31, 31);
        int iterations = 10000000;
        boolean putJustSomeMagicPlease = scanner.nextBoolean();
        ImageIO.write(makeFractal(width, height, startX, startY, backgroundColor, mainColor, accentuationColor, iterations, putJustSomeMagicPlease), "png", new File("D:/Bureau/fractals/fractal" + width + "x" + height + (putJustSomeMagicPlease ? "" : "" + startX + startY + backgroundColor.getRGB() + mainColor.getRGB()) + accentuationColor.getRGB() + iterations + ".png"));

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

    private static BufferedImage makeFractal(int width, int height, int startX, int startY, Color backgroundColor, Color mainColor, Color accentuationColor, int iterations, boolean putJustSomeMagicPlease) {

        RandomOperation random = new RandomOperation(3, 0, width, height);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        System.out.println("Creating the fractal...");
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(mainColor);

        for (int i = 0 ; i < iterations ; i++){

            g2d.fillRect(startX, startY, 1, 1);
            System.out.println("x : " + startX + ", y : " + startY);
            random.op(startX, startY);
            startX = RandomOperation.x;
            startY = RandomOperation.y;
        }

        System.out.println("Fractal finished, magic incoming. ;)");

        return improveAFractalMagically(image, backgroundColor, mainColor, accentuationColor, putJustSomeMagicPlease);
    }

    private static BufferedImage improveAFractalMagically(BufferedImage image, Color backgroundColor, Color mainColor, Color accentuationColor, boolean makeNewImage) {

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        if (makeNewImage){g2d = (Graphics2D) newImage.getGraphics();}

        System.out.println("Entering Magical World.");
        g2d.setColor(accentuationColor);

        for (int w = 0 ; w < width ; w++){
            for (int h = 0 ; h < height ; h++){

                if (image.getRGB(w, h) == mainColor.getRGB()){
                    if ((w + 1 < width && image.getRGB(w+1, h) == backgroundColor.getRGB()) || (w - 1 >= 0 && image.getRGB(w-1, h) == backgroundColor.getRGB()) || (h + 1 < height && image.getRGB(w, h+1) == backgroundColor.getRGB()) || (h - 1 >= 0 && image.getRGB(w, h-1) == backgroundColor.getRGB())){

                        g2d.fillRect(w, h, 1, 1);
                        System.out.println("Setting pixel.");
                    }
                } else {
                    System.out.println("No pixel for you.");
                }
            }
        }

        g2d.dispose();
        System.out.println("Magic has ended, returning to overworld.");

        return makeNewImage ? newImage : image;
    }

    private static BufferedImage makeSpecialFractal(BufferedImage image, Color backgroundColor, Color mainColor, int iterations){

        int width = image.getWidth();
        int height = image.getHeight();

        RandomOperation random = new RandomOperation(4, 0, width, height);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        System.out.println("Creating the fractal...");
        g2d.setColor(mainColor);

        for (int i = 0; i < iterations; ++i) {
            for (int x = 0; x < width; ++x) {
                for (int y = 0; y < height; ++y) {

                    if (image.getRGB(x, y) == mainColor.getRGB()) {
                        if ((x + 1 < width && image.getRGB(x + 1, y) == backgroundColor.getRGB()) || (x - 1 >= 0 && image.getRGB(x - 1, y) == backgroundColor.getRGB()) || (y + 1 < height && image.getRGB(x, y + 1) == backgroundColor.getRGB()) || (y - 1 >= 0 && image.getRGB(x, y - 1) == backgroundColor.getRGB())) {

                            g2d.fillRect(x, y, 1, 1);

                            System.out.println("x : " + x + ", y : " + y);

                            random.op(x, y);
                            x = RandomOperation.x;
                            y = RandomOperation.y;
                        }
                    }
                }
            }
        }

        g2d.dispose();
        System.out.println("Fractal finished, magic incoming. ;)");

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
