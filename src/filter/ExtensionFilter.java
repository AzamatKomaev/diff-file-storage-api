package filter;

import model.File;
import storage.Storage;

import java.util.Arrays;
import java.util.List;

public class ExtensionFilter extends Filter {
    public ExtensionFilter(Storage storage) {
        super(storage);
    }

    @Override
    public File[] filter(String value) {
        File[] filteredArray;

        List<File> filteredList = Arrays.stream(storage.getAllFiles())
                                         .filter(file -> file.getName().endsWith(value))
                                         .toList();

        filteredArray = new File[filteredList.size()];
        filteredList.toArray(filteredArray);
        return filteredArray;
    }
}
