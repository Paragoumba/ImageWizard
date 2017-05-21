package fr.paragoumba.imagewizard;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 21/05/2017.
 */

public class Patterns {

    private Patterns(){}

    static BufferedImage repeat(int width, int height, BufferedImage pattern){

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        for (int x = 0 ; x < width - pattern.getWidth() + 1 ; x+=pattern.getWidth()) {
            for (int y = 0 ; y < height - pattern.getHeight() + 1 ; y+=pattern.getHeight()) {
                g2d.drawImage(pattern, x, y, null);
            }
        }

        g2d.dispose();

        return image;
    }
}
