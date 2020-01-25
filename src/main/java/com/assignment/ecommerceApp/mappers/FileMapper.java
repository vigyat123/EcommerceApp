package com.assignment.ecommerceApp.mappers;

import com.assignment.ecommerceApp.dto.File;
import com.assignment.ecommerceApp.repositories.FileEntity;

public class FileMapper {
    public static File map(FileEntity fileEntity){
        File file = new File();
        file.setId(fileEntity.getId());
        file.setName(fileEntity.getName());
        file.setMimeType(fileEntity.getMimeType());
        file.setFile(fileEntity.getFile());
        return file;
    }
}
