package com.myfolder.myfolder.services.file;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateFileService {

    public void create(MultipartFile file, UUID folder) throws IOException {
        generateFile(file);
    }

    private void generateFile(MultipartFile file) throws IOException {
        File dir = new File("uploads/");
        if (!dir.exists())
            dir.mkdirs();
        Path filepath = Paths.get("uploads/", file.getOriginalFilename());
        Files.write(filepath, file.getBytes());
    }
}
