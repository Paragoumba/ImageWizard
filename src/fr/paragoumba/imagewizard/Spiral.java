package fr.paragoumba.imagewizard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spiral {

    private Spiral(){}

    static BufferedImage spiralIt(BufferedImage baseImage, int coef){

        if (baseImage.getHeight() == baseImage.getWidth()) {

            BufferedImage image = new BufferedImage(baseImage.getWidth(), baseImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();

            for (int x = 0; x < baseImage.getWidth(); ++x) {
                for (int y = 0; y < baseImage.getHeight(); ++y) {

                    int centerX = baseImage.getWidth() / 2;
                    int radius = x - centerX;
                    if (radius < 0) radius /= -1;
                    int angle = radius * 5 * coef;
                    if (radius < 1) radius++;
                    double rad = Math.toRadians(angle) + Math.toRadians(Math.acos((x - centerX) / radius));

                    int pointX = (int) (centerX + radius * Math.cos(rad));
                    int pointY = (int) (centerX + radius * Math.cos(rad));

                    graphics2D.setColor(new Color(baseImage.getRGB(x, y)));
                    graphics2D.drawRect(pointX, pointY, 1, 1);

                }
            }

            return image;
        }

        return baseImage;
    }
}
