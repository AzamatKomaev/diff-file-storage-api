package test;

import filter.ExtensionFilter;
import filter.Filter;
import filter.GtMegabyteSizeFilter;
import model.File;
import service.FilterChain;
import storage.FileServerStorage;
import storage.Storage;

import java.util.Arrays;

public class FilterTest {
    Storage storage = new FileServerStorage();

    public FilterTest() {
        // 0.5 mb, .txt
        storage.createFile(new File("anapa2004.txt", 524288, "root",
                               "doesnt_matter", "doesnt_matter"));
        // 2.7 mb, .java
        storage.createFile(new File("User.java", 2831155, "root",
                               "doesnt_matter", "doesnt_matter"));

        // 0.9 mb, .java
        storage.createFile(new File("UserService.java", 943718, "root",
                               "doesnt_matter", "doesnt_matter"));

        // 1.3 mb, .png
        storage.createFile(new File("screen.png", 1363148, "root",
                               "doesnt_matter", "doesnt_matter"));

        // 1.6 mb, .java
        storage.createFile(new File("Manager.java",  1677721, "root",
                               "doesnt_matter", "doesnt_matter"));

    }

    public void testGettingFilesWhereExtensionIsJavaAndSizeGreaterThan1MB() {
        File[] files = new FilterChain(storage, new GtMegabyteSizeFilter("1.0"))
            .filter(new ExtensionFilter("java"))
            // other filters
            .collect();

        assert files.length == 2;
        assert files[0].equals(storage.getFileByName("User.java"));
        assert files[1].equals(storage.getFileByName("Manager.java"));
    }
}
