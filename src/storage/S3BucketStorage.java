package storage;

import model.File;

import java.util.HashSet;
import java.util.Set;

public class S3BucketStorage implements Storage {
    private final Set<File> files;

    public S3BucketStorage() {
        files = new HashSet<>();
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
