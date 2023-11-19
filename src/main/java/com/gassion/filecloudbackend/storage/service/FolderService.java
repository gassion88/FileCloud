package com.gassion.filecloudbackend.storage.service;

import io.minio.messages.Item;

import java.util.List;

public interface FolderService {

    List<Item> getUserBucketItems(String userBucketName) ;

    void createUserBucket(String userId) ;

    void createFolder(String bucket, String path);

    void deleteFolder(String bucket, String path);

    void renameFolder();

    void moveFolder();

    void copyFolder(String sourceFolder, String targetFolder, String folder);
}
