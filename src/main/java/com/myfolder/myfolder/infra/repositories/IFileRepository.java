package com.myfolder.myfolder.infra.repositories;

import com.myfolder.myfolder.infra.entities.FileTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IFileRepository extends CrudRepository<FileTable, UUID> {
    public List<FileTable> findByFolderId(UUID folder);
}
