package filter;

import storage.Storage;

import model.File;

public abstract class Filter {
    protected Storage storage;

    public Filter(Storage storage) {
        this.storage = storage;
    }

    abstract File[] filter(String value);
}
