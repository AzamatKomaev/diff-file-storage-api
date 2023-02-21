package test;

import filter.Filter;
import filter.GtMegabyteSizeFilter;
import model.File;
import storage.FileServerStorage;
import storage.Storage;

import java.util.Arrays;

public class GtMegabyteSizeFilterTest {
    Storage storage = new FileServerStorage();

    public GtMegabyteSizeFilterTest() {
        // 0.5 mb
        storage.createFile(new File("anapa2004.txt", 524288, "root",
                               "doesnt_matter", "doesnt_matter"));
        // 2.7 mb
        storage.createFile(new File("troyan_pony.exe", 2831155, "root",
                               "doesnt_matter", "doesnt_matter"));

        // 0.9 mb
        storage.createFile(new File("screen.png", 943718, "root",
                               "doesnt_matter", "doesnt_matter"));

        // 1.3 mb
        storage.createFile(new File("screen.png", 1363148, "root",
                               "doesnt_matter", "doesnt_matter"));
    }

    public void testGettingFilesWhereSizeGreaterThan1MB() {
        Filter filter = new GtMegabyteSizeFilter(storage);
        File[] filteredFiles = filter.filter("1.0"); // filter by 1.0 mb

        assert filteredFiles.length == 2;
        assert filteredFiles[0].equals(storage.getFileByName("troyan_pony.exe"));
        assert filteredFiles[1].equals(storage.getFileByName("screen.png"));

    }
}
