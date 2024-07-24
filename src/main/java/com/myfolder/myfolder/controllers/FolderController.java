package com.myfolder.myfolder.controllers;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.services.folder.CreateFolderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folder")
@AllArgsConstructor
public class FolderController {
    private final CreateFolderService createFolderService;

    @PostMapping()
    public ResponseEntity<FolderEntity> create(@RequestBody String name, @RequestBody Long user) {
        FolderEntity folder = createFolderService.create(name, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(folder);
    }
}
