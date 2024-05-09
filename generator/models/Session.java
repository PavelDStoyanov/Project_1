package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private int id;
    private List<Image> images;

    public Session(int id) {
        this.images = new ArrayList();
        this.id = id;
    }

    public void addImage(Image image){
        images.add(image);
    }
    
    public void transformImages(Transformation transformation){
        for(Image element : images){
            element.applyTransformation(transformation);
        }
    }
}
