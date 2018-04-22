package fr.paragoumba.imagewizard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class ImageWizard extends Application {

    //private static BufferedImage square;
    //private static BufferedImage finalImage;

    public static JFrame frame = new JFrame("Fractal Creator Studio");
    public static JPanel panel = new JPanel();

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller.controller = fxmlLoader.getController();

        primaryStage.setTitle("ImageWizard");
        primaryStage.setScene(new Scene(root, 1000, 563));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(450);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image(ImageWizard.class.getResourceAsStream("res/wizard-face.png")));
        primaryStage.show();

    }

    public static void main(String[] args){

        launch(args);

        //Scanner scanner = new Scanner(System.in);
        //String path = System.getProperties().getProperty("java.home").startsWith("D:\\Program Files\\Java\\") ? "D:/Bureau/fractals/" : "C:/Users/parag/Desktop/fractals/";
        //long time = System.currentTimeMillis();

        //ImageIO.write(Spiral.spiralIt(ImageIO.read(new File("C:/Users/parag/Desktop/Dev/IW/spirals/first.jpg")), 1), "PNG", new File("C:/Users/parag/Desktop/Dev/IW/spirals/firstResult.png"));

        /*frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);*/

        //makeFractal()
        /*int width = 1920;
        int height = 1080;
        int startX = 960;
        int startY = 540;
        Color backgroundColor = new Color(255, 255, 255);
        Color mainColor = new Color(254, 255, 255);
        Color accentuationColor = new Color(0, 0, 0);
        int iterations = 10000000;*/

        //System.out.println("Put some magic ?");

        //boolean putJustSomeMagicPlease = scanner.nextBoolean();

        //ImageIO.write(Fractals.makeFractal(width, height, startX, startY, backgroundColor, mainColor, accentuationColor, iterations, putJustSomeMagicPlease), "png", new File(path + width + "x" + height + (putJustSomeMagicPlease ? "" : "" + startX + startY + backgroundColor.getRGB() + mainColor.getRGB()) + accentuationColor.getRGB() + iterations + ".png"));

        //makeSpecialFractal()
        //ImageIO.write(makeSpecialFractal(ImageIO.read(new File("D:/Bureau/fractals/Sans titre.png")), new Color(0, 255, 255), new Color(221, 221, 34), 1000), "png", new File("D:/Bureau/fractals/fractalpattern.png"));

        //testColor()
        /*BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, 80, 80);
        g2d.setColor(Color.blue);
        g2d.fillRect(10, 10, 20, 20);
        g2d.setColor(Color.cyan);
        g2d.fillArc(30, 30, 10, 10, 0, 360);
        g2d.dispose();

        testColor(image, Color.cyan);*/

        //Decomposer.decompose(ImageIO.read(new File("/home/paragoumba/Bureau/google.png")), 0.2);
        //System.out.println("Execution time : " + (System.currentTimeMillis() - time) + "ms.");

        /*BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, 80, 80);
        g2d.setColor(Color.BLUE);
        g2d.drawString("y", 5, 5);

        ImageIO.write(image, "png", new File("D:/Bureau/x.png"));*/

    }
}
