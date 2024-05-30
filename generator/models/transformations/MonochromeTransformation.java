package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.TransformationType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;

import java.awt.image.BufferedImage;

public class MonochromeTransformation extends Transformation{
    public MonochromeTransformation() {
        super.setTransformationType(TransformationType.monochrome);
    }

    @Override
    public BufferedImage transform(Image image) {
        //Image transformedImage = new Image(image.getBufferedImage(),image.getFilePath(),"");
        for (int i = 0; i < image.getY(); i++) {
            for (int j = 0; j < image.getX(); j++) {
                if(image.getIntMatrix()[i][j] > 128){
                    image.setMatrixElement(i,j,1);
                }else if(image.getIntMatrix()[i][j] < 128){
                    image.setMatrixElement(i,j,0);
                }
            }
        }
        image.createStringMatrixFromIntMatrix();
        return null;
    }
}
