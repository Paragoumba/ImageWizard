package fr.paragoumba.imagewizard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Paragoumba on 23/05/2017.
 */

public class Test {

    public static void main(String[] args) {

        JFrame jframe = new JFrame();
        JPanel jpanel = new JPanel();
        Color color = new Color(255, 0, 0);
        BufferedImage image = new BufferedImage(10, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        Graphics2D panelG2d = (Graphics2D) jpanel.getGraphics();

        jpanel.setSize(10, 1);
        jframe.add(jpanel);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {

            g2d.setColor(image.getRGB(0, 0) == new Color(255, 0, 0).getRGB() ? new Color(0, 255, 0) : new Color(255, 0, 0));

            for (int i = 0 ; i < 9 ; ++i) {

                g2d.fillRect(i, 1, 1, 1);
                SwingUtilities.invokeLater(() -> panelG2d.drawImage(image, 0, 0, null));

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {e.printStackTrace();}
            }
            return;
        }
    }
}
