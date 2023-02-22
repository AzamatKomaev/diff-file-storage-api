package filter;

import model.File;
import storage.Storage;

import java.util.Arrays;
import java.util.List;

public class GtMegabyteSizeFilter extends Filter {
    public GtMegabyteSizeFilter(String value) {
        super(value);
    }

    @Override
    public Filter filter(Filter filter) {
        double sizeInBytes = Math.round(Double.parseDouble(value) * 1024 * 1024);

        List<File> filteredList = Arrays.stream(filter.getFiles())
                                        .filter(file -> file.getSizeInBytes() > sizeInBytes)
                                        .toList();

        System.out.println("I am works in mg");
        this.files = new File[filteredList.size()];
        filteredList.toArray(this.files);
        return this;
    }
}
