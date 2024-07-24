package com.myfolder.myfolder.controllers;

import com.myfolder.myfolder.services.file.CreateFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
@AllArgsConstructor
public class FileController {

    private final CreateFileService createFileService;

    @PostMapping
    public ResponseEntity<String> create(@RequestParam("file") MultipartFile file, @RequestParam("folder") UUID folder) throws IOException {
        createFileService.create(file, folder);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }
}
