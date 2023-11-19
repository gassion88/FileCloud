package com.gassion.filecloudbackend.storage.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CopyFolderRequest(
        @NotBlank(message = "folder source is empty")
        String source,
        @NotBlank(message = "folder target is empty")
        String target) {
}
