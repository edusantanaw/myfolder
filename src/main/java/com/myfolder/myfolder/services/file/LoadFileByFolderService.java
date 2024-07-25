package com.myfolder.myfolder.services.file;

import com.myfolder.myfolder.domain.entities.FileEntity;
import com.myfolder.myfolder.infra.gateway.FileGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoadFileByFolderService {
    private final FileGateway fileGateway;

    public List<FileEntity> load(UUID folder) {
        List<FileEntity> files = fileGateway.loadByFolder(folder);
        return files;
    }
}
