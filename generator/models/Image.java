package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;

import java.nio.file.Path;

public class Image {
    private Path filePath;

    public Image(Path filePath) {
        this.filePath = filePath;
    }

    public void applyTransformation(Transformation transformation){
        transformation.transform(this);
    }

    public Path getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "Image{" +
                "filePath=" + filePath +
                '}';
    }
}
