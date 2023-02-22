package filter;

import model.File;

import java.util.Arrays;
import java.util.List;

public class ExtensionFilter extends Filter {
    public ExtensionFilter(String value) {
        super(value);
    }

    @Override
    public Filter filter(Filter filter) {
        List<File> filteredList = Arrays.stream(filter.getFiles())
                                         .filter(file -> file.getName().endsWith(value))
                                         .toList();

        System.out.println("I am works in extension");
        this.files = new File[filteredList.size()];
        filteredList.toArray(this.files);
        return this;
    }
}
