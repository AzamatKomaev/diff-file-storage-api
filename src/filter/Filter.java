package filter;

import storage.Storage;

import model.File;

import java.util.List;

public abstract class Filter {
    protected Storage storage;

    public Filter(Storage storage) {
        this.storage = storage;
    }

    public abstract File[] filter(String value);
}
