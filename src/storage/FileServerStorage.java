package storage;

import model.File;

import java.util.ArrayList;
import java.util.List;

public class FileServerStorage implements Storage {
    private final List<File> files;

    public FileServerStorage() {
        files = new ArrayList<>();
    }

    @Override
    public File[] getAllFiles() {
        File[] fileArray = new File[files.size()];
        files.toArray(fileArray);
        return fileArray;
    }

    @Override
    public File getFileByName(String name) {
        return files.stream()
                     .filter(file -> file.getName().equals(name))
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public void createFile(File f) {
        files.add(f);
    }
}
