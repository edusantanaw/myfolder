package com.myfolder.myfolder.infra.gateway;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import com.myfolder.myfolder.infra.entities.FolderTable;
import com.myfolder.myfolder.infra.entities.UserTable;
import com.myfolder.myfolder.infra.repositories.IFolderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class FolderGateway {
    private final IFolderRepository folderRepository;

    public FolderEntity create(FolderEntity folder) {
        FolderTable folderTable = FolderTable.builder()
                .user(UserTable.builder().id(folder.user()).build())
                .name(folder.name())
                .build();
        FolderTable created = folderRepository.save(folderTable);
        return created.toEntity();
    }

    public Optional<FolderEntity> loadById(UUID id) {
        Optional<FolderTable> folder = folderRepository.findById(id);
        return folder.map(FolderTable::toEntity);
    }
}
