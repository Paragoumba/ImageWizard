package fr.paragoumba.imagewizard.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 08/05/2018.
 */

public class Blurple {

    private static final Color BLURPLE = new Color(114, 137, 218);
    private static final Color DARK_BLURPLE = new Color(78, 93, 148);
    private static final int AVERAGE_BLURPLE = 156;
    private static final int AVERAGE_DARK_BLURPLE = 106;

    public static BufferedImage finalImage;

    public static void blurplize(BufferedImage image) {

        finalImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = finalImage.getGraphics();

        for (int x = 0; x < image.getWidth(); ++x){
            for (int y = 0; y < image.getHeight(); ++y){

                Color color = new Color(image.getRGB(x, y), true);
                int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                g.setColor(averageColor > AVERAGE_DARK_BLURPLE ? averageColor > AVERAGE_BLURPLE ? new Color(255, 255, 255, color.getAlpha()) : new Color(BLURPLE.getRed(), BLURPLE.getGreen(), BLURPLE.getBlue(), color.getAlpha()) : new Color(DARK_BLURPLE.getRed(), DARK_BLURPLE.getGreen(), DARK_BLURPLE.getBlue(), color.getAlpha()));
                //g.setColor(new Color((int) Math.round(color.getRed() * 0.9), (int) Math.round(color.getGreen() * 0.9), (int) Math.round(color.getBlue() * 0.9), color.getAlpha()));
                g.drawRect(x, y, 1, 1);

            }
        }
    }
}
