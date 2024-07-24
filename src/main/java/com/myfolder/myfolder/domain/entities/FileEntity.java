package com.myfolder.myfolder.domain.entities;

import java.util.UUID;

public record FileEntity(UUID id, String filename, Double fileLength, String type, Boolean isSafe, Boolean isDeleted,
                         UUID folderId, String path) {
}
