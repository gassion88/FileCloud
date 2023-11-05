package com.gassion.filecloudbackend.storage.model;

import java.time.ZonedDateTime;

public record BucketFile(String path, double size, ZonedDateTime lastModified) {
}
