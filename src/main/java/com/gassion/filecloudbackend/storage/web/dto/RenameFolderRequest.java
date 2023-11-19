package com.gassion.filecloudbackend.storage.web.dto;

import jakarta.validation.constraints.NotBlank;

public record RenameFolderRequest(
        @NotBlank(message = "folder source is empty")
        String source,
        @NotBlank(message = "folder newName is empty")
        String newName) {
}
