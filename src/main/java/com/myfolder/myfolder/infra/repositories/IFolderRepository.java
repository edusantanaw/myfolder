package com.myfolder.myfolder.infra.repositories;

import com.myfolder.myfolder.infra.entities.FolderTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IFolderRepository extends CrudRepository<FolderTable, UUID> {
}
