package com.gassion.filecloudbackend.storage.dao;

import io.minio.messages.Item;

import java.util.List;

public interface FolderDAO {

    List<Item> getUserBucket(String bucket);

    void createBucket(String bucketName);

    void createFolder(String bucket, String path);

    void deleteFolder(String bucket, String path);

    void copyFolder(String bucket, String sourceFolder, String targetFolder);
}
