package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.states.FileSystemState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemClosedState;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

public class FileSystem {
    private FileSystemState state;

    public FileSystem() {
        this.state = new FileSystemClosedState();
    }

    public void setState(FileSystemState state) {
        this.state = state;
    }

    public FileSystemState getState() {
        return state;
    }

    public void execute(Command command){
        command.execute();
    }
}
