package fr.paragoumba.imagewizard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Decomposer {

    private Decomposer(){}

    public static BufferedImage[] decompose(BufferedImage image, int width, int height){


        int imageWidth = height / 2;
        double ratio = (double) imageWidth / image.getWidth();
        int imageHeight = (int) Math.round(ratio * image.getHeight());
        double k = 1.2;

        BufferedImage red = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage green = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage blue = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage gray = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage alpha = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        BufferedImage resizedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        BufferedImage yellow = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage cyan = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage magenta = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage blackAndWhite = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        BufferedImage surprise = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        BufferedImage coef = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage finalImage2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D gRed = red.createGraphics();
        Graphics2D gGreen = green.createGraphics();
        Graphics2D gBlue = blue.createGraphics();
        Graphics2D gGray = gray.createGraphics();
        Graphics2D gAlpha = alpha.createGraphics();
        Graphics2D gResized = resizedImage.createGraphics();

        Graphics2D gYellow = yellow.createGraphics();
        Graphics2D gCyan = cyan.createGraphics();
        Graphics2D gMagenta = magenta.createGraphics();
        Graphics2D gBlackAndWhite = blackAndWhite.createGraphics();
        Graphics2D gSurprise = surprise.createGraphics();
        Graphics2D gCoef = coef.createGraphics();

        for (int x = 0; x < image.getWidth(); ++x){
            for (int y = 0; y < image.getHeight(); ++y){

                Color color = new Color(image.getRGB(x, y), true);

                gRed.setColor(new Color(color.getRed(), 0, 0, color.getAlpha()));
                gGreen.setColor(new Color(0, color.getGreen(), 0, color.getAlpha()));
                gBlue.setColor(new Color(0, 0, color.getBlue(), color.getAlpha()));

                int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                gGray.setColor(new Color(averageColor, averageColor, averageColor, color.getAlpha()));

                int alphaValue = color.getAlpha() * -1 + 255;

                gAlpha.setColor(new Color(alphaValue, alphaValue, alphaValue));
                gResized.setColor(color);
                
                int newX = (int) Math.round(x * ratio);
                int newY = (int) Math.round(y * ratio);

                gRed.drawRect(newX, newY, 1, 1);
                gGreen.drawRect(newX, newY, 1, 1);
                gBlue.drawRect(newX, newY, 1, 1);
                gGray.drawRect(newX, newY, 1, 1);
                gAlpha.drawRect(newX, newY, 1, 1);
                gResized.drawRect(newX, newY, 1, 1);


                gYellow.setColor(new Color(color.getRed(), color.getGreen(), 0));
                gCyan.setColor(new Color(0, color.getGreen(), color.getBlue()));
                gMagenta.setColor(new Color(color.getRed(), 0, color.getBlue()));
                gBlackAndWhite.setColor(new Color());
                gSurprise.setColor(new Color());
                gCoef.setColor(new Color(Math.round(color.getRed() * k), Math.round(color.getGreen() * k), Math.round(color.getBlue() * k)));

                gYellow.drawRect(newX, newY, 1, 1);
                gCyan.drawRect(newX, newY, 1, 1);
                gMagenta.drawRect(newX, newY, 1, 1);
                gBlackAndWhite.drawRect(newX, newY, 1, 1);
                gSurprise.drawRect(newX, newY, 1, 1);
                gCoef.drawRect(newX, newY, 1, 1);

            }
        }

        Graphics2D gFinal = finalImage.createGraphics();
        Graphics2D gFinal2 = finalImage2.createGraphics();

        gFinal.drawImage(red, 0, 0, null);
        gFinal.drawImage(green, imageWidth, 0, null);
        gFinal.drawImage(blue, imageWidth * 2, 0, null);
        gFinal.drawImage(alpha, 0, imageHeight, null);
        gFinal.drawImage(resizedImage, imageWidth, imageHeight, null);
        gFinal.drawImage(gray, imageWidth * 2, imageHeight, null);

        gFinal2.drawImage();
        gFinal2.drawImage();
        gFinal2.drawImage();
        gFinal2.drawImage();
        gFinal2.drawImage();
        gFinal2.drawImage();

        return new BufferedImage[]{finalImage, finalImage2};

    }
}
