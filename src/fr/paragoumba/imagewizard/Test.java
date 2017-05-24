package fr.paragoumba.imagewizard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 23/05/2017.
 */

public class Test {

    public static void main(String[] args){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        Color color = new Color(255, 0, 0);
        BufferedImage image = new BufferedImage(10, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            g2d.setColor(image.getRGB(0, 0) == new Color(255, 0, 0).getRGB() ? new Color(0, 255, 0) : new Color(255, 0, 0));

            for (int i = 0 ; i < 9 ; ++i) {
                g2d.fillRect(i, 1, 1, 1);
                SwingUtilities.invokeLater(() -> {
                    panel.getGraphics().drawImage(image, 0, 0, null);
                    frame.add(panel);
                    frame.pack();
                });
            }
            return;
        }
    }
}
