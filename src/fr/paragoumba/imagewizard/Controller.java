package fr.paragoumba.imagewizard;

import fr.paragoumba.imagewizard.objects.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;

public class Controller {

    public static Controller controller;

    private boolean isFirstImageDisplayed = true;
    private final String fileErrorMessage = "File didn't exists !";
    private final String saveErrorMessage = "Error in file saving ! Sorry ¯\\_(ツ)_/¯";
    private final String execTimeMessage = "Execution time ";
    public final String invalidArgument = "Invalid argument.";

    @FXML
    Label statusDecomposerLabel;

    @FXML
    TextField loadPathDecomposerTextField;

    @FXML
    Button loadDecomposerButton;

    @FXML
    TextField savePathDecomposerTextField;

    @FXML
    Button saveDecomposerButton;

    @FXML
    ImageView decomposerImageView;

    @FXML
    TextField filterDecomposerTextField;

    @FXML
    Button clearDecomposerButton;
    

    @FXML
    Label statusPngtosvgLabel;

    @FXML
    TextField loadPathPngtosvgTextField;

    @FXML
    Button loadPngtosvgButton;

    @FXML
    TextField savePathPngtosvgTextField;

    @FXML
    Button savePngtosvgButton;

    @FXML
    TextArea pngtosvgTextArea;

    @FXML
    TextField pixelSizePngtosvgTextField;

    @FXML
    Button clearPngtosvgButton;


    @FXML
    Label statusPatternsLabel;

    @FXML
    TextField loadPathPatternsTextField;

    @FXML
    Button loadPatternsButton;

    @FXML
    TextField savePathPatternsTextField;

    @FXML
    Button savePatternsButton;
    
    @FXML
    ImageView patternsImageView;

    @FXML
    Button clearPatternsButton;


    @FXML
    Label statusFractalsLabel;

    @FXML
    TextField loadPathFractalsTextField;

    @FXML
    Button loadFractalsButton;

    @FXML
    TextField savePathFractalsTextField;

    @FXML
    Button saveFractalsButton;

    @FXML
    ImageView fractalsImageView;

    @FXML
    Button clearFractalsButton;


    @FXML
    Label statusTranslationsLabel;

    @FXML
    TextField loadPathTranslationsTextField;

    @FXML
    Button loadTranslationsButton;

    @FXML
    TextField savePathTranslationsTextField;

    @FXML
    Button saveTranslationsButton;

    @FXML
    ImageView translationsImageView;

    @FXML
    Button clearTranslationsButton;


    @FXML
    Label statusSpiralsLabel;

    @FXML
    TextField loadPathSpiralsTextField;

    @FXML
    Button loadSpiralsButton;

    @FXML
    TextField savePathSpiralsTextField;

    @FXML
    Button saveSpiralsButton;

    @FXML
    ImageView spiralsImageView;

    @FXML
    Button clearSpiralsButton;

    
    @FXML
    Label statusBlurpleLabel;

    @FXML
    TextField loadPathBlurpleTextField;

    @FXML
    Button loadBlurpleButton;

    @FXML
    TextField savePathBlurpleTextField;

    @FXML
    Button saveBlurpleButton;

    @FXML
    ImageView blurpleImageView;

    @FXML
    Button clearBlurpleButton;


    @FXML
    public Label statusMTGALabel;

    @FXML
    TextField loadPathMTGATextField;

    @FXML
    Button loadMTGAButton;

    @FXML
    TextField savePathMTGATextField;

    @FXML
    Button saveMTGAButton;

    @FXML
    ImageView MTGAImageView;

    @FXML
    Button clearMTGAButton;

    @FXML
    public TextField colorsMTGATextField;

    @FXML
    public void initialize(){

        pixelSizePngtosvgTextField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {

                pixelSizePngtosvgTextField.setText(newValue.replaceAll("[^\\d]", ""));

            }
        });

        filterDecomposerTextField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {

                filterDecomposerTextField.setText(newValue.replaceAll("[^\\d]", ""));

            }
        });
    }

    @FXML
    public void changeDecomposerImage(){

        if (isFirstImageDisplayed){

            Image secondImage = Decomposer.secondImage == null ? null : SwingFXUtils.toFXImage(Decomposer.secondImage, null);
            isFirstImageDisplayed = false;

            decomposerImageView.setImage(secondImage);

        } else {

            Image firstImage = Decomposer.firstImage == null ? null : SwingFXUtils.toFXImage(Decomposer.firstImage, null);
            isFirstImageDisplayed = true;

            decomposerImageView.setImage(firstImage);

        }
    }

    @FXML
    public void runDecomposer() {

        long start = System.currentTimeMillis();

        try {

            Decomposer.decompose(ImageIO.read(new File(loadPathDecomposerTextField.getText())), Integer.parseInt(filterDecomposerTextField.getText()));
            statusDecomposerLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e) {

            statusDecomposerLabel.setText(fileErrorMessage);

        }

        if (isFirstImageDisplayed){

            Image firstImage = Decomposer.firstImage == null ? null : SwingFXUtils.toFXImage(Decomposer.firstImage, null);
            decomposerImageView.setImage(firstImage);

        } else {

            Image secondImage = Decomposer.secondImage == null ? null : SwingFXUtils.toFXImage(Decomposer.secondImage, null);
            decomposerImageView.setImage(secondImage);

        }
    }

    @FXML
    public void saveDecomposer(){

        if (Decomposer.firstImage != null && Decomposer.secondImage != null){

            try {

                String savePath = savePathFractalsTextField.getText();

                ImageIO.write(Decomposer.firstImage, "PNG", new File(savePath));
                ImageIO.write(Decomposer.secondImage, "PNG", new File(savePath.substring(0, savePath.lastIndexOf(".")) + "-2nd" + savePath.substring(savePath.lastIndexOf("."))));

            } catch (IOException e) {

                statusDecomposerLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runPNGToSVG() {

        long start = System.currentTimeMillis();

        try {

            pngtosvgTextArea.setText(PNGtoSVG.convert(ImageIO.read(new File(loadPathPngtosvgTextField.getText())), Integer.parseInt(pixelSizePngtosvgTextField.getText())));
            statusPngtosvgLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e) {

            statusPngtosvgLabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void savePNGToSVG(){

        if (pngtosvgTextArea.getText() != null){

            try(FileOutputStream fos = new FileOutputStream(new File(savePathPngtosvgTextField.getText()));
                ObjectOutputStream oos = new ObjectOutputStream(fos)){

                oos.writeChars(pngtosvgTextArea.getText());

            } catch (IOException e) {

                statusPngtosvgLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runPatterns(){

        long start = System.currentTimeMillis();

        try {

            Patterns.repeat(1920, 1080, ImageIO.read(new File(loadPathPatternsTextField.getText())));

            patternsImageView.setImage(Patterns.finalImage == null ? null : SwingFXUtils.toFXImage(Patterns.finalImage, null));
            statusPatternsLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e){

            statusPatternsLabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void savePatterns(){

        if (Patterns.finalImage != null){

            try {

                ImageIO.write(Patterns.finalImage, "PNG", new File(savePathPatternsTextField.getText()));

            } catch (IOException e) {

                statusPatternsLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runFractals(){

        long start = System.currentTimeMillis();
        Fractals.makeFractal(1920, 1080, 0, 0, Color.WHITE, Color.BLACK, Color.GRAY, 1000000, true);

        fractalsImageView.setImage(Fractals.finalImage == null ? null : SwingFXUtils.toFXImage(Fractals.finalImage, null));
        statusFractalsLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

    }

    @FXML
    public void saveFractals(){

        if (Fractals.finalImage != null){

            try {

                ImageIO.write(Fractals.finalImage, "PNG", new File(savePathFractalsTextField.getText()));

            } catch (IOException e) {

                statusFractalsLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runTranslations(){

        long start = System.currentTimeMillis();

        try {

            Translations.translateToText(ImageIO.read(new File(loadPathTranslationsTextField.getText())), new HashMap<>());

            //translationsImageView.setImage(image == null ? null : SwingFXUtils.toFXImage(image, null));
            System.out.println(Translations.finalText);
            statusTranslationsLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e){

            statusTranslationsLabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void saveTranslations(){

        if (Translations.finalText != null){

            try(FileOutputStream fos = new FileOutputStream(new File(saveTranslationsButton.getText()));
                ObjectOutputStream oos = new ObjectOutputStream(fos)){

                oos.writeChars(Translations.finalText);

            } catch (IOException e) {

                statusTranslationsLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runSpirals(){

        long start = System.currentTimeMillis();

        try {

            Spiral.spiralIt(ImageIO.read(new File(loadPathSpiralsTextField.getText())), 0);

            spiralsImageView.setImage(Spiral.finalImage == null ? null : SwingFXUtils.toFXImage(Spiral.finalImage, null));
            statusSpiralsLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e){

            statusSpiralsLabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void saveSpirals(){

        if (Spiral.finalImage != null){

            try {

                ImageIO.write(Spiral.finalImage, "PNG", new File(savePathSpiralsTextField.getText()));

            } catch (IOException e) {

                statusSpiralsLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runBlurple(){

        long start = System.currentTimeMillis();

        try {

            Blurple.blurplize(ImageIO.read(new File(loadPathBlurpleTextField.getText())));

            blurpleImageView.setImage(Blurple.finalImage == null ? null : SwingFXUtils.toFXImage(Blurple.finalImage, null));
            statusBlurpleLabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e){

            statusBlurpleLabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void saveBlurple(){

        if (Blurple.finalImage != null){

            try {

                ImageIO.write(Blurple.finalImage, "PNG", new File(savePathBlurpleTextField.getText()));

            } catch (IOException e){

                statusBlurpleLabel.setText(saveErrorMessage);

            }
        }
    }

    @FXML
    public void runMTGA(){

        long start = System.currentTimeMillis();

        try {

            MakeThemeGreatAgain.makeThemeGreatAgain(ImageIO.read(new File(loadPathMTGATextField.getText())));

            MTGAImageView.setImage(MakeThemeGreatAgain.finalImage == null ? null : SwingFXUtils.toFXImage(MakeThemeGreatAgain.finalImage, null));
            statusMTGALabel.setText(execTimeMessage + getExecTime(System.currentTimeMillis() - start));

        } catch (IOException e){

            statusMTGALabel.setText(fileErrorMessage);

        }
    }

    @FXML
    public void saveMTGA(){

        if (MakeThemeGreatAgain.finalImage != null){

            try {

                ImageIO.write(MakeThemeGreatAgain.finalImage, "PNG", new File(savePathMTGATextField.getText()));

            } catch (IOException e){

                statusMTGALabel.setText(saveErrorMessage);

            }
        }
    }

    private String getExecTime(double time){

        time /= 1000;

        return (double) Math.round(time * 100d) / 100d + "s";

    }
}