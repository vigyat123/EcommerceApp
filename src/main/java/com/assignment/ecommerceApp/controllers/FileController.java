package com.assignment.ecommerceApp.controllers;

import com.assignment.ecommerceApp.dto.File;
import com.assignment.ecommerceApp.exceptions.NotFoundException;
import com.assignment.ecommerceApp.repositories.FileRepository;
import com.assignment.ecommerceApp.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileController {
    private final FileService fileService;
    private final FileRepository fileRepository;

    @Autowired
    public FileController(final FileService fileService, final FileRepository fileRepository) {
        this.fileService = fileService;
        this.fileRepository = fileRepository;
    }

    /*@RequestMapping(
            value = "/file",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    ResponseEntity<String> addFile(@RequestParam("file") final MultipartFile file) throws IOException {
        if (fileRepository.findByNameAndMimeType(file.getOriginalFilename(), file.getContentType()).isPresent()){
            return new ResponseEntity<>("File Already Exists. If you still want to save the file more than once " +
                    "change the name of the file",HttpStatus.CONFLICT);
        }
            fileService.addFile(file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @RequestMapping(
            value = "/file/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public @ResponseBody
    File findFileById(@PathVariable("id") final Long fileId) {
        File file = null;
        try {
            file = fileService.findFileById(fileId);
        } catch (NotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return file;

        }
//        return new ResponseEntity<>(file,HttpStatus.CREATED);
        System.out.println(file);
        return file;
    }
}
