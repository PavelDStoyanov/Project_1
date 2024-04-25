package bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.workers.commands.request;

import bg.tu_varna.sit.b1.f22621682.project1.Project_1.generator.contracts.commands.FileSystem;

import java.io.File;

public class FileSystemImpl implements FileSystem {


    @Override
    public String openFile(File file, String input) {
        return input;
    }

    @Override
    public String closeFile() {
        return "Successfully closed file.xml";
    }

    @Override
    public String saveFile() {
        return null;
    }

    @Override
    public String saveFileAs() {
        return null;
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public String exit() {
        return null;
    }


}
