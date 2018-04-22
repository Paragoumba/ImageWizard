package fr.paragoumba.imagewizard.objects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Decomposer {

    private Decomposer(){}

    public static BufferedImage firstImage;
    public static BufferedImage secondImage;

    public static void decompose(BufferedImage image, double k) {

        k /= 1000;

        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        BufferedImage red = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage green = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage blue = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage gray = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage alpha = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage resizedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage finalImage = new BufferedImage(imageWidth * 3, imageHeight * 2, BufferedImage.TYPE_INT_ARGB);

        BufferedImage yellow = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage cyan = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage magenta = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage blackAndWhite = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage inverted = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage coef = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage finalImage2 = new BufferedImage(imageWidth * 3, imageHeight * 2, BufferedImage.TYPE_INT_ARGB);

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
        Graphics2D gInverted = inverted.createGraphics();
        Graphics2D gCoef = coef.createGraphics();

        for (int x = 0; x < image.getWidth(); ++x){
            for (int y = 0; y < image.getHeight(); ++y){

                Color color = new Color(image.getRGB(x, y), true);

                int newX = Math.round(x);
                int newY = Math.round(y);

                gResized.setColor(color);
                gResized.drawRect(newX, newY, 1, 1);

            }
        }

        for (int x = 0; x < imageWidth; ++x){
            for (int y = 0; y < imageHeight; ++y){

                Color color = new Color(resizedImage.getRGB(x, y), true);

                gRed.setColor(new Color(color.getRed(), 0, 0, color.getAlpha()));
                gGreen.setColor(new Color(0, color.getGreen(), 0, color.getAlpha()));
                gBlue.setColor(new Color(0, 0, color.getBlue(), color.getAlpha()));

                int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                gGray.setColor(new Color(averageColor, averageColor, averageColor, color.getAlpha()));

                int alphaValue = color.getAlpha() * -1 + 255;

                gAlpha.setColor(new Color(alphaValue, alphaValue, alphaValue));
                
                int newX = Math.round(x);
                int newY = Math.round(y);

                gRed.drawRect(newX, newY, 1, 1);
                gGreen.drawRect(newX, newY, 1, 1);
                gBlue.drawRect(newX, newY, 1, 1);
                gGray.drawRect(newX, newY, 1, 1);
                gAlpha.drawRect(newX, newY, 1, 1);


                gYellow.setColor(new Color(color.getRed(), color.getGreen(), 0, color.getAlpha()));
                gCyan.setColor(new Color(0, color.getGreen(), color.getBlue(), color.getAlpha()));
                gMagenta.setColor(new Color(color.getRed(), 0, color.getBlue(), color.getAlpha()));

                int averageNumber = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                gBlackAndWhite.setColor(averageNumber > 127 ? Color.WHITE : Color.BLACK);
                gInverted.setColor(new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue(), color.getAlpha()));

                int redNumber = (int) Math.round(color.getRed() * k);
                int greenNumber = (int) Math.round(color.getGreen() * k);
                int blueNumber = (int) Math.round(color.getBlue() * k);

                gCoef.setColor(new Color(redNumber > 255 ? 255 : redNumber, greenNumber > 255 ? 255 : greenNumber, blueNumber > 255 ? 255 : blueNumber, color.getAlpha()));

                gYellow.drawRect(newX, newY, 1, 1);
                gCyan.drawRect(newX, newY, 1, 1);
                gMagenta.drawRect(newX, newY, 1, 1);
                gBlackAndWhite.drawRect(newX, newY, 1, 1);
                gInverted.drawRect(newX, newY, 1, 1);
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

        gFinal2.drawImage(yellow, 0, 0, null);
        gFinal2.drawImage(cyan, imageWidth, 0, null);
        gFinal2.drawImage(magenta, imageWidth * 2, 0, null);
        gFinal2.drawImage(blackAndWhite, 0, imageHeight, null);
        gFinal2.drawImage(inverted, imageWidth, imageHeight, null);
        gFinal2.drawImage(coef, imageWidth * 2, imageHeight, null);

        firstImage = finalImage;
        secondImage = finalImage2;

    }
}
