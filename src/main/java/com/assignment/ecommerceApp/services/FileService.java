package com.assignment.ecommerceApp.services;

import com.assignment.ecommerceApp.dto.File;
import com.assignment.ecommerceApp.exceptions.AlreadyExistsException;
import com.assignment.ecommerceApp.exceptions.NotFoundException;
import com.assignment.ecommerceApp.mappers.FileMapper;
import com.assignment.ecommerceApp.repositories.FileEntity;
import com.assignment.ecommerceApp.repositories.FileRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class FileService {
    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void addFile(MultipartFile file) throws IOException {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFile(file.getBytes());
        fileEntity.setMimeType(file.getContentType());
        fileEntity.setName(file.getOriginalFilename());
        fileRepository.save(fileEntity);

    }

    public File findFileById(Long fileId) throws NotFoundException {
        Optional<FileEntity> fileEntityOptional = fileRepository.findById(fileId);
        if (!fileEntityOptional.isPresent()){
            throw new NotFoundException("File Not Found");
        }
        return FileMapper.map(fileEntityOptional.get());
    }
}
