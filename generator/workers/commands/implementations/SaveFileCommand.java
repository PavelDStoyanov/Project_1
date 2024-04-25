package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

public class SaveFileCommand implements Command {
    private FileSystemImpl fileSystem;

    public SaveFileCommand(FileSystemImpl fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute() {
        return this.fileSystem.saveFile();
    }
}
