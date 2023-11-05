package com.gassion.filecloudbackend.storage.dao.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.*;
import io.minio.messages.Item;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Repository
public class FolderDAOImpl implements FolderDAO {

    private final MinioClient minioClient;

    public FolderDAOImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public Iterable<Result<Item>> getUserBucket(String bucket) {
        return  minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucket).recursive(true).build());
    }

    @Override
    public void createBucket(String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.makeBucket(
                MakeBucketArgs.builder()
                        .bucket(bucketName)
                        .build());
    }
}
