package com.assignment.ecommerceApp.dto;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Objects;

public class File {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String mimeType;

    @Lob
    private byte[] file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file1 = (File) o;
        return Objects.equals(id, file1.id) &&
                Objects.equals(name, file1.name) &&
                Objects.equals(mimeType, file1.mimeType) &&
                Arrays.equals(file, file1.file);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, mimeType);
        result = 31 * result + Arrays.hashCode(file);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", file=" + Arrays.toString(file) +
                '}';
    }
}
