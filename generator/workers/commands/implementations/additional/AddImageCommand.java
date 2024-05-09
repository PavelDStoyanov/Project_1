package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.additional;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.models.Image;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

public class AddImageCommand implements Command{
    private FileSystem fileSystem;
    private Image image;

    public AddImageCommand(FileSystem fileSystem, Image image) {
        this.fileSystem = fileSystem;
        this.image = image;
    }

    @Override
    public void execute() {
        this.fileSystem.getState().addImage(image);
    }
}
