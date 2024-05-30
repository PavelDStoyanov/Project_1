package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.ImageType;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.transformations.Transformation;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

public class Image {
    private Path filePath;
    private BufferedImage bufferedImage;
    private int[][] intMatrix;
    private String[][] stringMatrix;
    private String fileContent;
    private int x;
    private int y;
    //private ImageType imageType;
    private ImageType formatType;
    private String fileTitle;



    public Image(BufferedImage bufferedImage, Path filePath, String fileContent) {
        this.bufferedImage = bufferedImage;
        this.filePath = filePath;
        this.x = 0;
        this.y = 0;
        this.intMatrix = this.createMatrixFromAnImage(fileContent);
        this.createStringMatrixFromIntMatrix();
        this.fileContent = fileContent;
        this.setDefaultImageType(this.fileTitle);

        //this.createStringFromStringMatrix();

    }

    public void applyTransformation(Transformation transformation){
        this.bufferedImage = transformation.transform(this);
    }

    public int[][] createMatrixFromAnImage(String file){
        if(file == null){
            System.out.println("The file is empty");
            return null;
        }else{


        int x, y, z = 0;

        String[] fileLines = file.split("\r\n");

        int k = 0;
        String temp = "";
        int stopIndex = 0;
        int count = 0;
        boolean flag = false;
        while(flag == false){
            temp = temp + file.charAt(k);
            if(file.charAt(k) == '\n') {

                if(count == 1){
                    stopIndex = k;
                    flag = true;
                }
                count++;
            }
            k++;
        }
            //System.out.println(temp);
            // System.out.println(stopIndex);

        //String image = file.substring(5,file.length());
        String image = file.substring(stopIndex + 1,file.length());
        String[] imageLines = image.split("\r\n");


        String[] dimensionsArray = fileLines[1].split(" ");
        //String[] dimensionsArray = fileLines[0].split(" ");

        x = Integer.parseInt(dimensionsArray[0]);
        y = Integer.parseInt(dimensionsArray[1]);
        this.x = x;
        this.y = y;
        //System.out.println(x);
        //System.out.println(y);
        String[][] stringMatrix = new String[y][x];
        int[][] intMatrix = new int[y][x];

        for (int i = 0; i < y; i++) {
            String[] line = imageLines[i].split(" ");
            z = 0;
            for (int j = 0; j < x; j++) {
                stringMatrix[i][j] = line[z];
                z++;
                intMatrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
            }
        }

        this.setFileTitle(fileLines[0]);
        return intMatrix;
        }
    }

    public void createStringMatrixFromIntMatrix(){
        String[][] stringMatrix = new String[this.y][this.x];
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {
                stringMatrix[i][j] = String.valueOf(intMatrix[i][j]);
                //intMatrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
            }
        }
        this.stringMatrix = stringMatrix;

    }

    public void createStringFromStringMatrix(){
        String fileContent = "";
        fileContent = fileContent + this.fileTitle + "\r\n" +  this.x + " " + this.y + "\r\n" ;
        for (int i = 0; i < y; i++) {

            for (int j = 0; j < x; j++) {
                fileContent = fileContent + this.stringMatrix[i][j] + " ";
                stringMatrix[i][j] = String.valueOf(intMatrix[i][j]);
                //intMatrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
            }
            fileContent = fileContent + "\r\n";
        }
        this.fileContent = fileContent;
    }

    public void setMatrixElement(int i, int j, int newValue){
        this.intMatrix[i][j] = newValue;
    }

    private void setDefaultImageType(String fileTitle){
        switch(fileTitle){
            case "P1":
                this.formatType = ImageType.PBM;
                //this.imageType = ImageType.monochrome;
                break;
            case "P3":
                this.formatType = ImageType.PPM;
                //this.imageType = ImageType.withColor;
                break;
            case "P5":
                this.formatType = ImageType.PGM;
                //this.imageType = ImageType.grayscale;
                break;
            default:
                this.formatType = null;
        }
//        if() {
//            this.imageType = ImageType.monochrome;
//        }else if() {
//            this.imageType = ImageType.grayscale;
//        }else if(){
//            this.imageType = ImageType.withColor;
//        }
    }


    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String[][] getStringMatrix() {
        return stringMatrix;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public int[][] getIntMatrix() {
        return intMatrix;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setIntMatrix(int[][] intMatrix) {
        this.intMatrix = intMatrix;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public String getFileName() {
        return filePath.getFileName().toString();
    }

    public Path getFilePath() {
        return filePath;
    }

    public ImageType getFormatType() {
        return formatType;
    }

    public void setFormatType(ImageType formatType) {
        this.formatType = formatType;
    }

    //    public ImageType getFileType() {
//        return imageType;
//    }
//
//    public void setImageType(ImageType imageType) {
//        this.imageType = imageType;
//    }

    @Override
    public String toString() {
        return "" + filePath.getFileName();
    }
}
