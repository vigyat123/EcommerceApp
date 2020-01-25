package com.assignment.ecommerceApp.repositories;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "file",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name", name = "mime_type")})
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "mime_type")
    private String mimeType;

    @Lob
    @Column(name="file")
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
        FileEntity that = (FileEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(mimeType, that.mimeType) &&
                Arrays.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, mimeType);
        result = 31 * result + Arrays.hashCode(file);
        return result;
    }
}
