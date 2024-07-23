package com.myfolder.myfolder.domain.entities;

import java.util.UUID;

public record FolderEntity(UUID id, String name, Long user) {
}
