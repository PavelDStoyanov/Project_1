package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.ImageType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;


public class GrayscaleTransformation extends Transformation{
    public GrayscaleTransformation() {
        super.setTransformationType(TransformationType.grayscale);
    }

    @Override
    public BufferedImage transform(Image image) {
//        //int x = BufferedImage.TYPE_BYTE_GRAY;
//        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
//        ColorConvertOp op = new ColorConvertOp(cs, null);
//        //BufferedImage grayscaleImage = op.filter(image, null);
//        //return grayscaleImage;
        if(image.getFileType() != ImageType.grayscale) {
            //Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
            if(image.getFileType() == ImageType.monochrome) {
                for (int i = 0; i < image.getY(); i++) {
                    for (int j = 0; j < image.getX(); j++) {
                        if (image.getIntMatrix()[i][j] > 128) {
                            image.setMatrixElement(i, j, 1);
                        } else if (image.getIntMatrix()[i][j] < 128) {
                            image.setMatrixElement(i, j, 0);
                        }
                    }
                }
                image.createStringMatrixFromIntMatrix();
                image.createStringFromStringMatrix();
                image.setFileType(ImageType.monochrome);
            }else if(image.getFileType() == ImageType.withColor){

            }

        }
        return null;
    }
}
