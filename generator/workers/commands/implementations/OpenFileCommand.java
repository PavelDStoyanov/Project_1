package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

import java.io.File;

public class OpenFileCommand implements Command {
    private FileSystemImpl fileSystem;
    private File file;

    public OpenFileCommand(FileSystemImpl fileSystem, File file) {
        this.fileSystem = fileSystem;
        this.file = file;
    }

    @Override
    public void execute() {
        this.fileSystem.openFile(file,"Successfully opened file.xml");
    }
}
