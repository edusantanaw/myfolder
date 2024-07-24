package com.myfolder.myfolder.infra.entities;

import com.myfolder.myfolder.domain.entities.FolderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@Table(name = "db_folder")
@NoArgsConstructor
@AllArgsConstructor
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

    public FolderEntity toEntity() {
        return new FolderEntity(id, name, user.id);
    }
}
