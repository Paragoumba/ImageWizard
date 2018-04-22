package fr.paragoumba.imagewizard.objects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Created by Paragoumba on 21/05/2017.
 */

public class Translations {

    private Translations(){}

    public static String finalText;

    /*public static BufferedImage translateToImage(BufferedImage image, HashMap<Color, Character> map){

        BufferedImage result = new BufferedImage();
        Graphics2D g2d = (Graphics2D) result.getGraphics();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0 ; x < width ; ++x){
            for (int y = 0 ; y < height ; ++y){

                g2d.drawString(map.get(new Color(image.getRGB(x, y))), x, y);

            }
        }
    }*/

    public static void translateToText(BufferedImage image, HashMap<Color, Character> map){

        StringBuilder result = new StringBuilder();
        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0 ; x < width ; ++x){
            for (int y = 0 ; y < height ; ++y){

                result.append(map.get(new Color(image.getRGB(x, y))));

            }
        }

        finalText = result.toString();

    }
}
