package com.gassion.filecloudbackend.storage.web;

import com.gassion.filecloudbackend.storage.model.BucketFile;

import java.util.List;

public record UserBucketResponse(List<BucketFile> userFiles) {
}
