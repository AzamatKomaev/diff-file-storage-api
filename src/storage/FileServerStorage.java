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
        return (File[]) files.toArray();
    }

    @Override
    public void createFile(File f) {
        files.add(f);
    }
}
