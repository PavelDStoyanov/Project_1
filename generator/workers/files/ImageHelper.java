package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.files;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.files.ReadFile;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.files.WriteFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageHelper {
    public BufferedImage read(Path filePath) throws IOException {

        try {
            //BufferedImage bufferedImage = null;
            BufferedImage bufferedImage = ImageIO.read(new File(filePath.toString()));
             //BufferedImage bufferedImage = ImageIO.read(filePath.toFile());
            if (bufferedImage == null) {
                System.out.println("Buffered image is null");
                System.out.println(filePath.toFile());
            }
            return bufferedImage;
            //return ImageIO.read(new File(filePath.getFileName().toString()));
            //return ImageIO.read(new File("tester.png"));
            //return ImageIO.read((InputStream) filePath);
            //return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void write(Path filePath, BufferedImage bufferedImage) throws IOException {
        try {
            ImageIO.write(bufferedImage, "png", filePath.toFile());
            //ImageIO.write(bufferedImage, "png", (ImageOutputStream) filePath);
            //Files.write(file.toPath(), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
