package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.Direction;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class RotateTransformation extends Transformation{
    private Direction direction;

    public RotateTransformation(Direction direction) {
        this.direction = direction;
        super.setTransformationType(TransformationType.ROTATE);
    }
    //    public RotateTransformation() {
//        super.setTransformationType(TransformationType.rotate);
//    }

    @Override
    public BufferedImage transform(Image image) {
        int[][] intMatrix = new int[image.getX()][image.getY()];
        for (int i = 0; i < image.getY(); i++) {
            for (int j = 0; j < image.getX(); j++) {
                intMatrix[image.getX() - j - 1][i] = image.getIntMatrix()[i][j];
            }
        }
        int x = image.getX();
        image.setX(image.getY());
        image.setY(x);
        image.setIntMatrix(intMatrix);
        image.createStringMatrixFromIntMatrix();
        image.createStringFromStringMatrix();

        System.out.println("Rotated image \"" + image.getFileName() + "\" content: \r\n" + image.getFileContent());
        return null;
    }
}
