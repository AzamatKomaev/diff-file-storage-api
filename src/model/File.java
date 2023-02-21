package model;

import java.util.Objects;

public class File {
    private String name;
    private int sizeInBytes;
    private String createdBy;
    private String dateCreated;
    private String dateUpdated;

    public File(String name, int sizeInBytes, String createdBy, String dateCreated, String dateUpdated) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(int sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File file)) return false;
        return sizeInBytes == file.sizeInBytes && Objects.equals(name, file.name) && Objects.equals(createdBy, file.createdBy) && Objects.equals(dateCreated, file.dateCreated) && Objects.equals(dateUpdated, file.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sizeInBytes, createdBy, dateCreated, dateUpdated);
    }

    @Override
    public String toString() {
        return "File{name=" + name + "}";
    }
}
