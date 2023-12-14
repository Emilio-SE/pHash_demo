package org.pHashAlgorithm;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class PHash {

    private CImage cImage = new CImage();

    private static final int SIZE = 8;
    public long getPHash(String path) {

        long hash = 1;

        try{

            File file = new File(path);
            BufferedImage rgbImage = ImageIO.read(file);

            BufferedImage greyImage = cImage.rgb2gray(rgbImage);
            BufferedImage resizedImage = cImage.resizeImage(greyImage, SIZE, SIZE);
            hash = pHashAlgorithm(resizedImage);

        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(Long.toBinaryString(hash));

        return hash;

    }


    public long getHammingDistance(long hash1, long hash2) {

        long distance = 0;
        long xor = hash1 ^ hash2;

        while (xor != 0) {
            distance++;
            xor &= (xor - 1);
        }

        return distance;

    }

    private long pHashAlgorithm(BufferedImage image){

        int average = getAverageGrayscale(image);

        if (average == 0 || average == 255) {
            average = 128;
        }

        long hash = 0;
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixelValue = (image.getRGB(x, y) & 0xFF) >= average ? 1 : 0;
                hash = (hash << 1) | pixelValue;
            }
        }

        return hash;

    }

    private int getAverageGrayscale(BufferedImage image){

        int totalPixels = SIZE * SIZE;
        int sum = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixelValue = image.getRGB(x, y) & 0xFF;
                sum += pixelValue;
            }
        }

        return sum / totalPixels;

    }

}
