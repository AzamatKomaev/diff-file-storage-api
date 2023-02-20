package storage;

import model.File;

/*
    The difference between FileServerStorage and S3BucketStorage is
    different types for "files" field (Set and List). It shows that you can use any object supports
    sequence objects (such as List, Set, etc.)
    to save your files there.
 */
public interface Storage {
    File[] getAllFiles();
    void createFile(File f);

    // some another methods
}
