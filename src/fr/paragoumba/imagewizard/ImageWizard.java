package fr.paragoumba.imagewizard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

public class ImageWizard extends Application {


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

    }
}
