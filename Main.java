package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.BasicCommands;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystemImpl fileSystem = new FileSystemImpl();
        Scanner scanner = new Scanner(System.in);
        BasicCommands basicCommands;

        File file = null;


        do {
            System.out.println("Choose a command:");
            System.out.println("open, close, save, saveAs, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine();
            basicCommands = BasicCommands.valueOf(choice);
            switch (basicCommands) {
                case open:
                    OpenFileCommand openFileCommand = new OpenFileCommand(fileSystem, file);
                    openFileCommand.execute();
                    break;
                case close:
                    CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystem);
                    closeFileCommand.execute();
                    break;
                case save:
                    SaveFileCommand saveFileCommand = new SaveFileCommand(fileSystem);
                    saveFileCommand.execute();
                    break;
                case saveAs:
                    SaveFileAsCommand saveFileAsCommand =  new SaveFileAsCommand(fileSystem);
                    saveFileAsCommand.execute();
                    break;
                case help:
                    HelpCommand helpCommand = new HelpCommand(fileSystem);
                    helpCommand.execute();
                    break;
                case exit:
                    ExitCommand exitCommand = new ExitCommand(fileSystem);
                    exitCommand.execute();
                    break;

            }
        } while (!basicCommands.equals(BasicCommands.exit));
    }
}
