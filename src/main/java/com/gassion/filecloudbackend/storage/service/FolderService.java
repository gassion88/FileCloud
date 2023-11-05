package com.gassion.filecloudbackend.storage.service;

import com.gassion.filecloudbackend.storage.web.UserBucketResponse;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface FolderService {

    List<Item> getUserBucketItems() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;

    void createFolder();

    void deleteFolder();

    void renameFolder();

    void moveFolder();

}
