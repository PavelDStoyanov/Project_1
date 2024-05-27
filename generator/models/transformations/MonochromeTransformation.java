package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.image.BufferedImage;

public class MonochromeTransformation extends Transformation{
    public MonochromeTransformation() {
        super.setTransformationType(TransformationType.monochrome);
    }

    @Override
    public void transform(BufferedImage image) {

    }
}
