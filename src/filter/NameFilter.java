package filter;

import storage.Storage;

import model.File;

import java.util.Arrays;
import java.util.List;


public class NameFilter extends Filter {
    public NameFilter(Storage storage) {
        super(storage);
    }

    @Override
    public File[] filter(String value) {
        File[] filteredArray;

        List<File> filteredList = Arrays.stream(storage.getAllFiles())
                                         .filter(file -> file.getName().equals(value))
                                         .toList();

        filteredArray = new File[filteredList.size()];
        filteredList.toArray(filteredArray);
        return filteredArray;
    }
}
