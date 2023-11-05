package com.gassion.filecloudbackend.storage.web.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateFolderRequest(
        @NotBlank(message = "new folder path is empty")
        String path) {
}
