package filter;

import model.File;
import storage.Storage;

import java.util.Arrays;

public class ExtensionFilter extends Filter {
    public ExtensionFilter(Storage storage) {
        super(storage);
    }

    @Override
    public File[] filter(String value) {
        return (File[]) Arrays.stream(storage.getAllFiles())
                               .filter(file -> file.getName().endsWith(value))
                               .toArray();
    }
}
