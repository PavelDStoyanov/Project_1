package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;

public class Image {
    public void applyTransformation(Transformation transformation){
        transformation.transform(this);
    }
}
