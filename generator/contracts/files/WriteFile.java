package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.files;

import java.io.IOException;
import java.nio.file.Path;

public interface WriteFile {
    public void write(Path filePath, String data) throws IOException;
}
