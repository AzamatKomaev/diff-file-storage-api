package filter;

import storage.Storage;

import model.File;

import java.util.Arrays;


public class NameFilter extends Filter {
    public NameFilter(Storage storage) {
        super(storage);
    }

    @Override
    public File[] filter(String value) {
        return (File[]) Arrays.stream(storage.getAllFiles())
                              .filter(file -> file.getName().equals(value))
                              .toArray();
    }
}
