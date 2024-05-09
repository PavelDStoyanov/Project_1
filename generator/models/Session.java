package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private int id;
    private List<Image> images;
    private List<Transformation> transformations;

    public Session(int id) {
        this.id = id;
        this.images = new ArrayList();
        this.transformations = new ArrayList();
    }

    public void addImage(Image image){
        images.add(image);
    }

    public void addTransformation(Transformation transformation){
        transformations.add(transformation);
    }

    public void transformImages(Transformation transformation){
        for(Image element : images){
            element.applyTransformation(transformation);
        }
    }

    public void applyAllTransformations(){
        for(Transformation element : transformations){
            this.transformImages(element);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Transformation> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<Transformation> transformations) {
        this.transformations = transformations;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", images=" + images +
                ", transformations=" + transformations +
                '}';
    }
}
