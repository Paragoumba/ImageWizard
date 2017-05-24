package fr.paragoumba.imagewizard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static fr.paragoumba.imagewizard.IW.frame;
import static fr.paragoumba.imagewizard.IW.panel;

/**
 * Created by Paragoumba on 21/05/2017.
 */

public class Fractals {

    private Fractals(){}

    static BufferedImage makeFractal(int width, int height, int startX, int startY, Color backgroundColor, Color mainColor, Color accentuationColor, int iterations, boolean putJustSomeMagicPlease) {

        RandomOperation random = new RandomOperation(3, 0, width, height);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        System.out.println("Creating the fractal...");
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(mainColor);

        for (int i = 0 ; i < iterations ; i++){

            g2d.fillRect(startX, startY, 1, 1);

            SwingUtilities.invokeLater(() -> {
                panel.getGraphics().drawImage(image, 0, 0, null);
                frame.pack();
            });

            System.out.println("x : " + startX + ", y : " + startY);
            random.op(startX, startY);
            startX = RandomOperation.x;
            startY = RandomOperation.y;
        }

        System.out.println("Fractal finished, magic incoming. ;)");

        return improveAFractalMagically(image, backgroundColor, mainColor, accentuationColor, putJustSomeMagicPlease);
    }

    static BufferedImage improveAFractalMagically(BufferedImage image, Color backgroundColor, Color mainColor, Color accentuationColor, boolean makeNewImage) {

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

    static BufferedImage makeSpecialFractal(BufferedImage image, Color backgroundColor, Color mainColor, int iterations){

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
}
