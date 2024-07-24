package com.myfolder.myfolder.services.folder;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.infra.gateway.FolderGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateFolderService {
    private final FolderGateway folderGateway;

    public FolderEntity create(String name, Long user) {
        FolderEntity folder = new FolderEntity(null, name, user);
        return folderGateway.create(folder);
    }
}
