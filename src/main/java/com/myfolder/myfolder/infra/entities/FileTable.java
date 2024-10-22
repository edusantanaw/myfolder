package com.myfolder.myfolder.infra.entities;

import com.myfolder.myfolder.domain.entities.FileEntity;
import com.myfolder.myfolder.domain.entities.FolderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "db_file")
@NoArgsConstructor
@AllArgsConstructor
public class FileTable {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String filename;
    Long fileLength;
    String type;
    Boolean isSafe;
    Boolean deleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="folderId")
    FolderTable folder;
    String path;

    public FileEntity toEntity(){
        return new FileEntity(id, filename,fileLength, type, isSafe,deleted, folder.id, path );
    }
}
