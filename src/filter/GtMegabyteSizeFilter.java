package filter;

import model.File;
import storage.Storage;

import java.util.Arrays;
import java.util.List;

public class GtMegabyteSizeFilter extends Filter {
    public GtMegabyteSizeFilter(Storage storage) {
        super(storage);
    }

    @Override
    public File[] filter(String value) {
        File[] filteredArray;
        double sizeInBytes = Math.round(Double.parseDouble(value) * 1024 * 1024);

        List<File> filteredList = Arrays.stream(storage.getAllFiles())
                                        .filter(file -> file.getSizeInBytes() > sizeInBytes)
                                        .toList();

        filteredArray = new File[filteredList.size()];
        filteredList.toArray(filteredArray);
        return filteredArray;
    }
}
