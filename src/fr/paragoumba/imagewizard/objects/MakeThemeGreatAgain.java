package fr.paragoumba.imagewizard.objects;

import fr.paragoumba.imagewizard.Controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

public class MakeThemeGreatAgain {

    //D:\Desktop\goomba-80x80.png
    //D:\Pictures\Background\well-fuck-you-too.jpg
    //114,137,218;78,93,148;255,255,255

    public static BufferedImage finalImage;

    public static void makeThemeGreatAgain(BufferedImage image) {

        final ArrayList<Entry<Color, Integer>> colors = new ArrayList<>();
        String[] colorStrings = Controller.controller.colorsMTGATextField.getText().split(";");

        try {

            for (String colorString : colorStrings) {

                String[] components = colorString.split(",");

                if (components.length > 2) {

                    int r = Integer.parseInt(components[0]);
                    int g = Integer.parseInt(components[1]);
                    int b = Integer.parseInt(components[2]);

                    colors.add(new SimpleEntry<>(new Color(r, g, b), (r + g + b) / 3));

                }
            }

        } catch (IllegalArgumentException e){

            Controller.controller.statusMTGALabel.setText(Controller.controller.invalidArgument);

        }

        colors.sort(Comparator.comparingInt(Entry::getValue));

        System.out.println(colors);

        finalImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = finalImage.getGraphics();

        for (int x = 0; x < image.getWidth(); ++x){
            for (int y = 0; y < image.getHeight(); ++y){

                Color color = new Color(image.getRGB(x, y), true);
                int averageColor = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                for (Entry<Color, Integer> newColor : colors){

                    if (averageColor < newColor.getValue()){

                        g.setColor(new Color(newColor.getKey().getRed(), newColor.getKey().getGreen(), newColor.getKey().getBlue(), color.getAlpha()));
                        break;

                    }
                }

                g.drawRect(x, y, 1, 1);

            }
        }
    }
}
