package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.exceptions;

import java.io.File;

public class FileReplaceException extends Exception{
    public FileReplaceException(File file) {
        super(String.format("An error occured while modifying the file", file.getPath()));
    }
}
