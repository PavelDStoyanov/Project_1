package bg.tu_varna.sit.b1.f22621682.project1.Project_1;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.Command;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.enums.BasicCommands;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.implementations.*;
import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.invoker.FileSystem;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        FileSystem fileSystem = new FileSystem();
        Scanner scanner = new Scanner(System.in);
        BasicCommands basicCommands = BasicCommands.help;
        String input = "Teston";
        String filePathFolder = "D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\";
        Path defaultFilePath = Path.of("D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\default.txt");
        //Path filePath2 = Path.of("D:\\tu varna\\OOP1\\project1\\src\\bg\\tu_varna\\sit\\b1\\f22621682\\project1\\Project_1\\files\\new.txt");
        Path filePath = defaultFilePath;
        Map<BasicCommands,Command> menu = new HashMap<>();



        do{
            System.out.println("\nChoose a command:");
            System.out.println("open <file>, close, save, saveas <file>, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine().toLowerCase();
            String[] inputs = choice.split(" ");
            try{
                basicCommands = BasicCommands.valueOf(inputs[0]);
            }catch (Exception e){
                System.out.println("This command does not exist");
                continue;
            }
            if(inputs.length > 1) {
                filePath = Path.of(filePathFolder + inputs[1]);
            }else{
                filePath = defaultFilePath;
            }
            menu.put(BasicCommands.open, new OpenFileCommand(fileSystem,filePath));
            menu.put(BasicCommands.close, new CloseFileCommand(fileSystem));
            menu.put(BasicCommands.save, new SaveFileCommand(fileSystem, input));
            menu.put(BasicCommands.saveas, new SaveFileAsCommand(fileSystem,filePath,input));
            menu.put(BasicCommands.help, new HelpCommand(fileSystem));
            menu.put(BasicCommands.exit, new ExitCommand(fileSystem));


//            if(menu.containsKey(basicCommands)){
//                fileSystem.execute(menu.get(basicCommands));
//            }else{
//                System.out.println("/This command does not exist");
//            }

            fileSystem.execute(menu.get(basicCommands));

        }while(!basicCommands.equals(BasicCommands.exit));


        /*do {
            System.out.println("\nChoose a command:");
            System.out.println("open <file>, close, save, saveas <file>, help, exit");
            System.out.print("> ");
            choice = scanner.nextLine();
            String[] inputs = choice.split(" ");

            try{
                basicCommands = BasicCommands.valueOf(inputs[0]);
            }catch (IllegalArgumentException e){
                System.out.println("This command does not exist");
                continue;
            }
            switch (basicCommands) {
                case open:
                    if(inputs.length > 1){
                    filePath = Path.of(filePathFolder + inputs[1]);

                    Command openFileCommand = new OpenFileCommand(fileSystem, filePath);
                    //openFileCommand.execute();
                    fileSystem.execute(openFileCommand);
                    }else{
                        System.out.println("Wrong input format");
                    }
                    break;
                case close:
                    Command closeFileCommand = new CloseFileCommand(fileSystem);
                    //closeFileCommand.execute();
                    fileSystem.execute(closeFileCommand);
                    break;
                case save:
                    Command saveFileCommand = new SaveFileCommand(fileSystem, input);
                    //saveFileCommand.execute();
                    fileSystem.execute(saveFileCommand);
                    break;
                case saveas:
                    if(inputs.length > 1) {
                        filePath = Path.of(filePathFolder + inputs[1]);
                        Command saveFileAsCommand = new SaveFileAsCommand(fileSystem, filePath, input);
                        //saveFileAsCommand.execute();
                        fileSystem.execute(saveFileAsCommand);
                    }
                    else{
                        System.out.println("Wrong input format");
                    }

                    break;
                case help:
                    Command helpCommand = new HelpCommand(fileSystem);
                    //helpCommand.execute();
                    fileSystem.execute(helpCommand);
                    break;
                case exit:
                    Command exitCommand = new ExitCommand(fileSystem);
                    //exitCommand.execute();
                    fileSystem.execute(exitCommand);
                    break;

            }
        } while (!basicCommands.equals(BasicCommands.exit));*/
    }
}
