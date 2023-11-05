package com.gassion.filecloudbackend.storage.dao;

import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface FolderDAO {

    Iterable<Result<Item>> getUserBucket(String bucket);

    void createBucket(String bucketName);
}
