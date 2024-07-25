package com.myfolder.myfolder.controllers;

import com.myfolder.myfolder.domain.entities.FileEntity;
import com.myfolder.myfolder.domain.exceptions.NotFoundException;
import com.myfolder.myfolder.services.file.CreateFileService;
import com.myfolder.myfolder.services.file.LoadFileByFolderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
@AllArgsConstructor
public class FileController {

    private final CreateFileService createFileService;
    private final LoadFileByFolderService loadFileByFolderService;

    @PostMapping
    public ResponseEntity<String> create(@RequestParam("file") MultipartFile file, @RequestParam("folder") UUID folder) throws IOException, NotFoundException {
        createFileService.create(file, folder);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    @GetMapping("/folder/{folder}")
    public ResponseEntity<List<FileEntity>> loadByFolder(@RequestParam("folder") UUID folder) {
        List<FileEntity> files = loadFileByFolderService.load(folder);
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
