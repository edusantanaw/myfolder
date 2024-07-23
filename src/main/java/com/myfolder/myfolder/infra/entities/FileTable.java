package com.myfolder.myfolder.infra.entities;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity(name = "db_file")
@Data
@Builder
@Table(name = "db_file")
public class FileTable {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String filename;
    Double fileLength;
    String type;
    Boolean isSafe;
    Boolean deleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="folderId")
    FolderEntity folder;
}
