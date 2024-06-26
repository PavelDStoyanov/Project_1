package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.ImageType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.image.BufferedImage;

public class MonochromeTransformation extends Transformation{
    public MonochromeTransformation() {
        super.setTransformationType(TransformationType.MONOCHROME);
    }

    @Override
    public BufferedImage transform(Image image) {
        if(image.getFormatType() != ImageType.PBM) {//Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
            for (int i = 0; i < image.getY(); i++) {
                for (int j = 0; j < image.getX(); j++) {
                    if (image.getIntMatrix()[i][j] > 128) {
                        image.setMatrixElement(i, j, 1);
                    } else if (image.getIntMatrix()[i][j] < 128) {
                        image.setMatrixElement(i, j, 0);
                    }
                }
            }
            image.setFileTitle("P1");
            image.createStringMatrixFromIntMatrix();
            image.createStringFromStringMatrix();
            image.setFormatType(ImageType.PBM);

        }
        System.out.println("Monochrome image \"" + image.getFileName() + "\" content: \r\n" + image.getFileContent());
        return null;
    }
}
