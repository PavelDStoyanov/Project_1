package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

import java.nio.file.Path;

public class AddImageCommand implements Command{
    private FileSystem fileSystem;
    private Path filepath;

    public AddImageCommand(FileSystem fileSystem, Path filepath) {
        this.fileSystem = fileSystem;
        this.filepath = filepath;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().addImage(filepath);
    }
}
