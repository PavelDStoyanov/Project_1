package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Image {
    private Path filePath;
    private BufferedImage bufferedImage;

    public Image(BufferedImage bufferedImage, Path filePath) {
        this.bufferedImage = bufferedImage;
        this.filePath = filePath;
    }

    public void applyTransformation(Transformation transformation){
        this.bufferedImage = transformation.transform(this.bufferedImage);
    }


    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getFileName() {
        return filePath.getFileName().toString();
    }

    public Path getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "" + filePath.getFileName();
    }
}
