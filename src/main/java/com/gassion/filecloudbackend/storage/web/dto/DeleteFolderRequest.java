package com.gassion.filecloudbackend.storage.web.dto;

import jakarta.validation.constraints.NotBlank;

public record DeleteFolderRequest(
        @NotBlank(message = "deleting folder path is empty")
        String path) {
}
