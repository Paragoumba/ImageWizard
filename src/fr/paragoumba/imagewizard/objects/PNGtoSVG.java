package fr.paragoumba.imagewizard.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 19/04/2018.
 */

public class PNGtoSVG {

    public static String convert(BufferedImage image, int pixelWidth) {

        StringBuilder builder = new StringBuilder();
        builder.append("<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" width=\"").append(image.getWidth() * pixelWidth).append("\" height=\"").append(image.getHeight() * pixelWidth).append("\">");

        for (int x = 0; x < image.getWidth(); ++x){
            for (int y = 0; y < image.getHeight(); ++y){

                Color color = new Color(image.getRGB(x, y), true);
                builder.append("\n    <rect x=\"").append(x * pixelWidth).append("\" y=\"").append(y * pixelWidth).append("\" width=\"").append(pixelWidth).append("\" height=\"").append(pixelWidth).append("\" style=\"fill:rgba(").append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue()).append(",").append(color.getAlpha()).append(")").append("\"/>");

            }
        }

        builder.append("\n</svg>");

        return builder.toString();

    }
}
