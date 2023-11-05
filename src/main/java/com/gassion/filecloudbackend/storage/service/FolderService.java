package com.gassion.filecloudbackend.storage.service;

import io.minio.errors.*;
import io.minio.messages.Item;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface FolderService {

    List<Item> getUserBucketItems(String userBucketName) ;

    void createUserBucket(String userId) ;

    void createFolder(String bucket, String path);

    void deleteFolder();

    void renameFolder();

    void moveFolder();

}
