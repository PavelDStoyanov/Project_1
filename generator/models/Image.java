package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Image {
    private String fileName;
    private BufferedImage bufferedImage;

    public Image(BufferedImage bufferedImage, String fileName) {
        this.bufferedImage = bufferedImage;
        this.fileName = fileName;
    }

    public void applyTransformation(Transformation transformation){
        transformation.transform(this.bufferedImage);
    }


    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "Image{" +
                "bufferedImage=" + bufferedImage +
                '}';
    }
}
