package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.image.BufferedImage;

public abstract class Transformation {
    //private Image image;
    private TransformationType transformationType;
    public abstract BufferedImage transform(BufferedImage image);


    public void setTransformationType(TransformationType transformationType) {
        this.transformationType = transformationType;
    }

    public TransformationType getTransformationType() {
        return transformationType;
    }

    @Override
    public String toString() {
        return "" + transformationType;
    }

}
