package com.myfolder.myfolder.services.file;

import com.myfolder.myfolder.domain.entities.FileEntity;
import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.domain.exceptions.NotFoundException;
import com.myfolder.myfolder.infra.gateway.FileGateway;
import com.myfolder.myfolder.infra.gateway.FolderGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreateFileService {
    private final String PATH = "uploads/";

    private final FileGateway fileGateway;
    private final FolderGateway folderGateway;

    public FileEntity create(MultipartFile file, UUID folder) throws IOException, NotFoundException {
        Optional<FolderEntity> folderEntity = folderGateway.loadById(folder);
        if (folderEntity.isEmpty()) throw new NotFoundException("Repositorio não encontrado!");
        generateFile(file);
        return fileGateway.create(new FileEntity(
                null,
                file.getOriginalFilename(),
                file.getSize(),
                file.getContentType(),
                true,
                false,
                folder,
                PATH
        ));
    }

    private void generateFile(MultipartFile file) throws IOException {
        File dir = new File(PATH);
        if (!dir.exists()) dir.mkdirs();
        Path filepath = Paths.get(PATH, file.getOriginalFilename());
        Files.write(filepath, file.getBytes());
    }
}
