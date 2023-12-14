package org.pHashAlgorithm;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CImage {

    public BufferedImage rgb2gray(BufferedImage rgbImage) {

        int width = rgbImage.getWidth();
        int height = rgbImage.getHeight();

        BufferedImage grayscaleImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for(int yPosition = 0; yPosition < height; yPosition++){
            for(int xPosition = 0; xPosition < width; xPosition++){

                int rgbPixel = rgbImage.getRGB(xPosition,yPosition);

                int redValue = (rgbPixel >> 16) & 0xff;
                int greenValue = (rgbPixel >> 8) & 0xff;
                int blueValue = (rgbPixel) & 0xff;


                int grayValue = (int) (
                        0.299 * redValue +
                        0.587 * greenValue +
                        0.114 * blueValue
                );

                int grayPixel = (grayValue << 16) | (grayValue << 8) | grayValue;

                grayscaleImage.setRGB(xPosition, yPosition, grayPixel);
            }
        }

        return grayscaleImage;

    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_BYTE_GRAY);

        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        return outputImage;
    }
    
}
