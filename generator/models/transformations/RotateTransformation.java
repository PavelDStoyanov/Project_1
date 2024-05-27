package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class RotateTransformation extends Transformation{
    public RotateTransformation() {
        super.setTransformationType(TransformationType.rotate);
    }

    @Override
    public BufferedImage transform(BufferedImage image) {
        return null;
    }
}
