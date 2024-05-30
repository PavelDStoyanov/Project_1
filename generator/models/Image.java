package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.FileType;
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
    private FileType fileType;



    public Image(BufferedImage bufferedImage, Path filePath, String fileContent) {
        this.bufferedImage = bufferedImage;
        this.filePath = filePath;
        this.x = 0;
        this.y = 0;
        this.intMatrix = this.createMatrixFromAnImage(fileContent);
        this.createStringMatrixFromIntMatrix();
        this.fileContent = fileContent;
        //this.createStringFromStringMatrix();

    }

    public void applyTransformation(Transformation transformation){
        this.bufferedImage = transformation.transform(this);
    }

    public int[][] createMatrixFromAnImage(String file){
        int x, y, z = 0;

        String[] fileLines = file.split("\r\n");

        String image = file.substring(5,file.length());
        String[] imageLines = image.split("\r\n");

        String[] dimensionsArray = fileLines[0].split(" ");

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
        return intMatrix;
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
        fileContent = fileContent + this.x + " " + this.y + "\r\n" ;
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

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "" + filePath.getFileName();
    }
}
