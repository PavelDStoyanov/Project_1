package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request.FileSystemImpl;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystemImpl fileSystem = new FileSystemImpl();
        Scanner scanner = new Scanner(System.in);
        File file = null;

        do {
            System.out.println("Choose a command:");
            System.out.println("open, close, save, save as, help, exit");
            choice = scanner.nextLine();
            switch (choice) {
                case "open": OpenFileCommand openFileCommand = new OpenFileCommand(fileSystem, file);
                    System.out.println(openFileCommand.execute());
                    break;
                case "close": CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystem);
                    System.out.println(closeFileCommand.execute());
                    break;
                case "save": new SaveFileCommand(fileSystem);
                    break;
                case "save as": new SaveFileAsCommand(fileSystem);
                    break;
                case "help": new HelpCommand(fileSystem);
                    System.out.println("Help");
                    break;
                case "exit": new ExitCommand(fileSystem);
                    break;

            }
        } while (!choice.equals("exit"));
    }
}
