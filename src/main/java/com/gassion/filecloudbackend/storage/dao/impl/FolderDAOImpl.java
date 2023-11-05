package com.gassion.filecloudbackend.storage.dao.impl;

import com.gassion.filecloudbackend.storage.dao.FolderDAO;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.stereotype.Repository;

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
}
