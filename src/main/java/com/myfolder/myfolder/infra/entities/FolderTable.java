package com.myfolder.myfolder.infra.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity(name = "db_folder")
@Data
@Builder
@Table(name = "db_folder")
public class FolderTable {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdBy")
    UserTable user;
    @OneToMany(fetch = FetchType.LAZY)
    List<FileTable> files;
}
