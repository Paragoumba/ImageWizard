package fr.paragoumba.imagewizard.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 21/05/2017.
 */

public class Patterns {

    private Patterns(){}

    public static BufferedImage finalImage;

    public static void repeat(int width, int height, BufferedImage pattern){

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();

        for (int x = 0; x < width - pattern.getWidth() + 1; x += pattern.getWidth()) {
            for (int y = 0; y < height - pattern.getHeight() + 1; y += pattern.getHeight()) {

                g.drawImage(pattern, x, y, null);

            }
        }

        finalImage = image;

    }
}
