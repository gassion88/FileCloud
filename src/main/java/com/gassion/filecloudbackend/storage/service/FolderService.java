package com.gassion.filecloudbackend.storage.service;

import io.minio.messages.Item;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface FolderService {

    List<Item> getUserBucketItems(String userBucketName) ;

    void createUserBucket(String userId) ;

    void createFolder(String bucket, String path);

    void deleteFolder(String bucket, String path);

    void renameFolder(String bucket, @NotBlank String source, @NotBlank String s);

    void moveFolder(String bucket, @NotBlank String source, @NotBlank String target);

    void copyFolder(String bucket, String targetFolder, String folder);
}
