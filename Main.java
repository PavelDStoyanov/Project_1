package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.BasicCommands;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.states.FileSystemOpenState;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        BasicCommands basicCommands;

        Path filePath = null;


        do {
            System.out.println("Choose a command:");
            System.out.println("open, close, save, saveas, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine();
            basicCommands = BasicCommands.valueOf(choice);
            switch (basicCommands) {
                case open:
                    OpenFileCommand openFileCommand = new OpenFileCommand(fileSystem, filePath);
                    //openFileCommand.execute();
                    fileSystem.execute(openFileCommand);
                    break;
                case close:
                    CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystem);
                    //closeFileCommand.execute();
                    fileSystem.execute(closeFileCommand);
                    break;
                case save:
                    SaveFileCommand saveFileCommand = new SaveFileCommand(fileSystem, filePath);
                    //saveFileCommand.execute();
                    fileSystem.execute(saveFileCommand);
                    break;
                case saveas:
                    SaveFileAsCommand saveFileAsCommand =  new SaveFileAsCommand(fileSystem, filePath);
                    //saveFileAsCommand.execute();
                    fileSystem.execute(saveFileAsCommand);
                    break;
                case help:
                    HelpCommand helpCommand = new HelpCommand(fileSystem);
                    //helpCommand.execute();
                    fileSystem.execute(helpCommand);
                    break;
                case exit:
                    ExitCommand exitCommand = new ExitCommand(fileSystem);
                    //exitCommand.execute();
                    fileSystem.execute(exitCommand);
                    break;

            }
        } while (!basicCommands.equals(BasicCommands.exit));
    }
}
