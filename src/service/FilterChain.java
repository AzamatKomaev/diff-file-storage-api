package service;

import filter.Filter;
import model.File;
import storage.Storage;

public class FilterChain {
    private Filter currentFilter;

    public FilterChain(Storage storage, Filter firstFilter) {
        this.currentFilter = firstFilter;
        this.currentFilter.setFiles(storage.getAllFiles());
        this.currentFilter.filter(this.currentFilter);
    }

    public FilterChain filter(Filter filter) {
        filter.filter(this.currentFilter);
        this.currentFilter = filter;
        return this;
    }

    public File[] collect() {
        return currentFilter.getFiles();
    }
}
