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
        if(image.getFormatType() != ImageType.PGM) {
            //Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
            if(image.getFormatType() == ImageType.PBM) {
                for (int i = 0; i < image.getY(); i++) {
                    for (int j = 0; j < image.getX(); j++) {
                        if (image.getIntMatrix()[i][j] == 1 ) {
                            image.setMatrixElement(i, j, 255);
                        } else if (image.getIntMatrix()[i][j] == 0) {
                            image.setMatrixElement(i, j, 0);
                        }
                    }
                }
                image.setFileTitle("P5");
                image.createStringMatrixFromIntMatrix();
                image.createStringFromStringMatrix();
                image.setFormatType(ImageType.PGM);

            }


             else if(image.getFormatType() == ImageType.PPM) {
                    for (int i = 0; i < image.getY(); i++) {
                        for (int j = 0; j < image.getX(); j++) {
                            if (image.getIntMatrix()[i][j] == 1 ) {
                                image.setMatrixElement(i, j, 128);
                            } else if (image.getIntMatrix()[i][j] == 0) {
                                image.setMatrixElement(i, j, 0);
                            }
                        }
                    }
                    image.setFileTitle("P3");
                    image.createStringMatrixFromIntMatrix();
                    image.createStringFromStringMatrix();
                    image.setFormatType(ImageType.PPM);

                }




        }
        System.out.println("Grayscale image \"" + image.getFileName() + "\" content: \r\n" + image.getFileContent());
        return null;
    }
}
