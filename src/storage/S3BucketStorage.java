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
        return (File[]) files.toArray();
    }

    @Override
    public void createFile(File f) {
        files.add(f);
    }
}
