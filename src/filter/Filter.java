package filter;

import storage.Storage;

import model.File;

public abstract class Filter {
    protected String value;
    protected File[] files;

    public Filter(String value) {
        this.value = value;
    }

    public abstract Filter filter(Filter filter);

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }
}
