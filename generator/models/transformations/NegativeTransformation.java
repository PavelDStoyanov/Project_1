package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.ImageType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.image.BufferedImage;

public class NegativeTransformation extends Transformation{
    public NegativeTransformation() {
        super.setTransformationType(TransformationType.negative);
    }

    @Override
    public BufferedImage transform(Image image) {
        if(image.getFormatType() == ImageType.PBM) {//Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
            for (int i = 0; i < image.getY(); i++) {
                for (int j = 0; j < image.getX(); j++) {
                    if (image.getIntMatrix()[i][j] ==  1) {
                        image.setMatrixElement(i, j, 0);
                    } else if (image.getIntMatrix()[i][j] == 0) {
                        image.setMatrixElement(i, j, 1);
                    }
                }
            }

            image.createStringMatrixFromIntMatrix();
            image.createStringFromStringMatrix();


        }
        else if(image.getFormatType() == ImageType.PGM || image.getFormatType() == ImageType.PPM) {//Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
            for (int i = 0; i < image.getY(); i++) {
                for (int j = 0; j < image.getX(); j++) {
                    image.setMatrixElement(i, j, 255-image.getIntMatrix()[i][j]);
                }
            }

            image.createStringMatrixFromIntMatrix();
            image.createStringFromStringMatrix();


        }
        System.out.println("Negative image \"" + image.getFileName() + "\" content: \r\n" + image.getFileContent());
        return null;
    }
}
