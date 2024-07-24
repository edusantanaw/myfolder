package com.myfolder.myfolder.infra.gateway;

import com.myfolder.myfolder.domain.entities.FileEntity;
import com.myfolder.myfolder.infra.entities.FileTable;
import com.myfolder.myfolder.infra.entities.FolderTable;
import com.myfolder.myfolder.infra.repositories.IFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileGateway {
    private final IFileRepository fileRepository;

    public FileEntity create(FileEntity data) {
        FileTable fileTable = FileTable.builder()
                .fileLength(data.fileLength())
                .deleted(false)
                .filename(data.filename())
                .type(data.type())
                .isSafe(data.isSafe())
                .folder(FolderTable.builder().id(data.folderId()).build())
                .path(data.path())
                .build();
        FileTable created = fileRepository.save(fileTable);
        return  created.toEntity();
    }
}
